package org.baticuisine.dao.impl;

import org.baticuisine.config.DatabaseConnection;
import org.baticuisine.dao.ProjetDAO;
import org.baticuisine.entities.Projet;

import java.sql.*;

public class ProjetDAOImpl implements ProjetDAO {
    private final Connection connection;
    {
        try {
            connection= DatabaseConnection.getInstance().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addClient(Projet projet) {
        String query = "INSERT INTO projet (nomprojet, surface, idclient) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, projet.getNomProjet());
            statement.setDouble(2, projet.getSurface());
            statement.setDouble(3, projet.getClient().getId());
            statement.executeUpdate();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    projet.setId(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
