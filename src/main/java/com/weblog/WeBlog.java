package com.weblog;

import java.sql.*;
import java.util.Scanner;

import com.weblog.database.interfaces.*;
import com.weblog.entity.BloggerProfile;
import com.weblog.database.implementations.*;
import com.weblog.database.Repository;
import com.weblog.service.interfaces.*;
import com.weblog.service.implementations.*;
import com.weblog.service.Service;
import com.weblog.ui.authentication.AuthenticationPresenter;
import com.weblog.ui.MainPresenter;

public class WeBlog {
    public static void main(String[] args) {
        System.out.println("\nWeBlog Starting...");
        WeBlog weBlogDriver = new WeBlog();
        weBlogDriver.begin();
    }

    public void begin() {
        try (Connection db = createDBConnection();
             Scanner scanner = new Scanner(System.in);) {
            System.out.println("Database connection established.");

            BloggerDao bloggerDao = new BloggerDaoImpl(db);
            BlogDao blogDao = new BlogDaoImpl(db);
            ReaderDao readerDao = new ReaderDaoImpl(db);
            Repository repository = new Repository(bloggerDao, blogDao, readerDao);

            BloggerManager bloggerManager = new BloggerManagerImpl(repository);
            BlogManager blogManager = new BlogManagerImpl(repository);
            ReaderManager readerManager = new ReaderManagerImpl(repository);
            Service service = new Service(bloggerManager, blogManager, readerManager);

            AuthenticationPresenter authenticationPresenter = new AuthenticationPresenter(service, scanner);
            BloggerProfile sessionData = authenticationPresenter.begin();

            if (sessionData != null) {
                MainPresenter mainPresenter = new MainPresenter(service, sessionData, scanner);
                mainPresenter.begin();
            } 
            System.out.println("Exiting WeBlog!");

        } catch (SQLException e) {
            System.out.println("Failed to connect to the database: " + e.getMessage());
            e.printStackTrace();
        } 
    }

    private Connection createDBConnection() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/weblog";
        String user = "jon";
        String password = "123";
        
        System.out.println("Connecting to database...");
        return DriverManager.getConnection(url, user, password);
    }
}
