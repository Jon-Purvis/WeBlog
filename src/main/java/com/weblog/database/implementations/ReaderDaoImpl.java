package com.weblog.database.implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.weblog.database.interfaces.ReaderDao;

public class ReaderDaoImpl implements ReaderDao{
    private Connection connection;

    public ReaderDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<String> addReaders(String userEmail, List<String> readerEmailList) {
        String sql = "INSERT INTO reader (blogger_email, reader_email) VALUES (?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            
            for (String readerEmail : readerEmailList) {
                preparedStatement.setString(1, userEmail);
                preparedStatement.setString(2, readerEmail);
                // add to batch so I can insert all at once
                preparedStatement.addBatch(); 
            }

            // insert batches
            preparedStatement.executeBatch();
            return readerEmailList; 

        } catch (SQLException e) {
            System.out.println("Error adding readers: " + e.getMessage());
            return null;
        }
    }

    @Override
    public Boolean isReaderOfBlogger(String reader, String blogger) {
        String query = "SELECT COUNT(*) FROM reader WHERE blogger_email = ? AND reader_email = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, blogger);
            preparedStatement.setString(2, reader);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                // check for a matching record
                return resultSet.getInt("count") == 1;
            }
        } catch (SQLException e) {
            System.out.println("Error checking reader relationship" + e.getMessage());
        }
        return false;
    }
}
