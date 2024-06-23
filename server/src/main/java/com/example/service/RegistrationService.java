package com.example.service;

import com.example.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegistrationService {
    private final String jdbcURL = "jdbc:mysql://localhost:3306/registrationdb";
    private final String jdbcUsername = "yourusername";
    private final String jdbcPassword = "yourpassword";

    public void registerUser(User user) throws SQLException {
        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword)) {
            String query = "INSERT INTO usuarios (nombre, pais) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user.getNombre());
            preparedStatement.setString(2, user.getPais());
            preparedStatement.executeUpdate();
        }
    }
}
