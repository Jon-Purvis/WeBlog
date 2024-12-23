package com.weblog.database.implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.weblog.database.interfaces.BloggerDao;
import com.weblog.entity.Blogger;

public class BloggerDaoImpl implements BloggerDao {
    private Connection connection;

    public BloggerDaoImpl(Connection connection) {
        this.connection = connection;
    }

    // returns a Blogger object, or null if registration fails
    @Override
    public Blogger registerBlogger(Blogger blogger) {
        String sql = "INSERT INTO blogger (email, password, name, address) VALUES (?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, blogger.getEmail());
            preparedStatement.setString(2, blogger.getPassword()); 
            preparedStatement.setString(3, blogger.getName());
            preparedStatement.setString(4, blogger.getAddress());
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                // If blogger was inserted, insert interests
                if (blogger.getInterests() != null && !blogger.getInterests().isEmpty()) {
                    sql = "INSERT INTO blogger_interest (email, interest) VALUES (?, ?)";
                    try (PreparedStatement ps = connection.prepareStatement(sql)) {
                        for (String interest : blogger.getInterests()) {
                            ps.setString(1, blogger.getEmail());
                            ps.setString(2, interest);
                            // add to batch so I can insert all at once
                            ps.addBatch(); 
                        }
                        // insert batches
                        ps.executeBatch(); 
                    }
                }
                return blogger;
            }
        } catch (SQLException e) {
            System.out.println("Error registering blogger: " + e.getMessage());
        }
        return null;  
    }

    @Override
    public List<Blogger> getAllBloggers() {
        List<Blogger> bloggers = new ArrayList<>();
        String sql = "SELECT * FROM blogger";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                bloggers.add(resultSetToBlogger(resultSet));
            }
        } catch (SQLException e) {
            System.out.println("Error listing all bloggers: " + e.getMessage());
        }
        return bloggers;
    }

    @Override
    public Blogger getBloggerByEmail(String email) {
        Blogger blogger = null;
        String sql = "SELECT * FROM blogger WHERE email = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                blogger = resultSetToBlogger(resultSet);
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving blogger by email: " + e.getMessage());
        }
        return blogger;
    }

    // Helper method to map a ResultSet row to a Blogger object
    private Blogger resultSetToBlogger(ResultSet resultSet) throws SQLException {
        Blogger blogger = new Blogger();
        blogger.setEmail(resultSet.getString("email"));
        blogger.setPassword(resultSet.getString("password"));
        blogger.setName(resultSet.getString("name"));
        blogger.setAddress(resultSet.getString("address"));
        return blogger;
    }
}