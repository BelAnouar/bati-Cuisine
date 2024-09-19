package org.baticuisine.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static DatabaseConnection instance;
    private Connection connection;
    private String url = "jdbc:postgresql://localhost:5432/cuisine";
    private String username = "postgres";
    private String password = "sde";

    private DatabaseConnection() throws SQLException {
        try {
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            System.out.println("Database Connection Creation Failed : " + ex.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static DatabaseConnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new DatabaseConnection();
        } else if (instance.getConnection().isClosed()) {
            instance = new DatabaseConnection();
        }

        return instance;
    }
}