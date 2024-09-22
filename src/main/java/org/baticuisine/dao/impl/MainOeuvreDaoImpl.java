package org.baticuisine.dao.impl;

import org.baticuisine.config.DatabaseConnection;
import org.baticuisine.dao.MainOeuvreDao;
import org.baticuisine.entities.MainOeuvre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MainOeuvreDaoImpl implements MainOeuvreDao {
    private final Connection connection;
    {
        try {
            connection= DatabaseConnection.getInstance().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void insertOeuvre(MainOeuvre mainOeuvre) {
        String sql = "INSERT INTO maindoeuvre (nom, typecomposant, tauxhoraire, tauxTVA, projetid, heurestravail, productiviteouvrier) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, mainOeuvre.getNom());
            pstmt.setString(2, mainOeuvre.getTypeComposant().name());
            pstmt.setDouble(3, mainOeuvre.getTauxHoraire());
            pstmt.setDouble(4, mainOeuvre.getTauxTVA());
            pstmt.setInt(5, mainOeuvre.getProjet().getId());
            pstmt.setDouble(6, mainOeuvre.getHeuresTravail());
            pstmt.setDouble(7, mainOeuvre.getProductiviteOuvrier());

            pstmt.executeUpdate();
            System.out.println("MainOeuvre inserted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
