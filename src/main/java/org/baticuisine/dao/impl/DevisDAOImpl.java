package org.baticuisine.dao.impl;

import org.baticuisine.config.DatabaseConnection;
import org.baticuisine.dao.DevisDAO;
import org.baticuisine.entities.Devis;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DevisDAOImpl implements DevisDAO {

    private final Connection connection;
    {
        try {
            connection= DatabaseConnection.getInstance().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void insertDevis(Devis devis) {
        String insertQuery = "INSERT INTO devis (montantEstime, dateEmission, dateValidite, accepte, idProjet) "
                + "VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {


            preparedStatement.setDouble(1, devis.getMontantEstime());
            preparedStatement.setDate(2, java.sql.Date.valueOf(devis.getDateEmission()));
            preparedStatement.setDate(3, java.sql.Date.valueOf(devis.getDateValidite()));
            preparedStatement.setBoolean(4, devis.getAccepte());
            preparedStatement.setInt(5, devis.getProjet().getId());


            int rowsAffected = preparedStatement.executeUpdate();


            if (rowsAffected > 0) {
                System.out.println("Devis inserted successfully!");
            } else {
                System.out.println("Failed to insert devis.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}