package com.weblog.database.implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.weblog.database.interfaces.BlogDao;
import com.weblog.entity.Blog;

public class BlogDaoImpl implements BlogDao {
    private Connection connection;

    public BlogDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Blog postBlog(Blog blog) {
        String sql = "INSERT INTO blog (id, title, body, is_private, date_time, email) VALUES (DEFAULT, ?, ?, ?, CURRENT_TIMESTAMP, ?) RETURNING *"; // For PostgreSQL

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, blog.getTitle());
            preparedStatement.setString(2, blog.getBody());
            preparedStatement.setBoolean(3, blog.getIsPrivate());
            preparedStatement.setString(4, blog.getEmail());

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSetToBlog(resultSet);
            }
        } catch (SQLException e) {
            System.out.println("Error posting blog: " + e.getMessage());
        }
        // failed to insert
        return null; 
    }

    @Override
    public List<Blog> getAllBlogs() {
        List<Blog> blogs = new ArrayList<>();

        String sql = "SELECT * FROM blog"; 
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                blogs.add(resultSetToBlog(resultSet));
            }
        } catch (SQLException e) {
            System.out.println(("Error listing all blogs" + e.getMessage()));
        }

        return blogs;
    }

    @Override
    public List<Blog> getPublicBlogsOfBlogger(String email) {
        List<Blog> publicBlogs = new ArrayList<>();

        String sql = "SELECT * FROM blog WHERE email = ? AND is_private = FALSE";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, email);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                publicBlogs.add(resultSetToBlog(resultSet));
            }

        } catch (SQLException e) {
            System.out.print("Error retrieving blogs" + e.getMessage());
        }
        return publicBlogs;
    }

    @Override
    public List<Blog> getAllBlogsOfBlogger(String email) {
        List<Blog> blogs = new ArrayList<>();

        String sql = "SELECT * FROM blog WHERE email = ?"; 
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, email);

            ResultSet resultSet = preparedStatement.executeQuery(); 
            while (resultSet.next()) {
                blogs.add(resultSetToBlog(resultSet));
            }
        } catch (SQLException e) {
            System.out.println(("Error listing all blogs" + e.getMessage()));
        }
        return blogs;
    }

    private Blog resultSetToBlog(ResultSet resultSet) throws SQLException {
        Blog blog = new Blog();
        blog.setId(resultSet.getInt("id"));
        blog.setTitle(resultSet.getString("title"));
        blog.setBody(resultSet.getString("body"));
        blog.setIsPrivate(resultSet.getBoolean("is_private"));
        blog.setCreatedAt(resultSet.getTimestamp("date_time").toLocalDateTime());
        blog.setEmail(resultSet.getString("email"));
        return blog;
    }
}
