package org.baticuisine.dao.impl;

import org.baticuisine.config.DatabaseConnection;
import org.baticuisine.dao.ClientDAO;
import org.baticuisine.entities.Client;

import java.sql.*;

public class ClientDAOImpl implements ClientDAO {

    private final Connection connection;

    {
        try {
            connection = DatabaseConnection.getInstance().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addClient(Client client) {

        String sql = "INSERT INTO client (nom, adresse, telephone, estProfessionnel) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, client.getNom());
            pstmt.setString(2, client.getAdresse());
            pstmt.setString(3, client.getTelephone());
            pstmt.setBoolean(4, client.getEstProfessionnel());
            pstmt.executeUpdate();

            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    client.setId(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {

            throw new RuntimeException("Error adding client", e);
        }
    }


}
