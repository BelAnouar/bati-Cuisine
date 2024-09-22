package org.baticuisine.dao.impl;

import org.baticuisine.config.DatabaseConnection;
import org.baticuisine.dao.MaterielDao;
import org.baticuisine.entities.Materiel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MaterialDaoImpl implements MaterielDao {
    private final Connection connection;
    {
        try {
            connection= DatabaseConnection.getInstance().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(Materiel materiel) {
        String sql = "INSERT INTO materiel (nom, typecomposant, tauxTVA, projetid, coutunitaire, quantite, couttransport, coefficientqualite) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, materiel.getNom());
            pstmt.setString(2, materiel.getTypeComposant().name());
            pstmt.setDouble(3, materiel.getTauxTVA());
            pstmt.setInt(4, materiel.getProjet().getId());
            pstmt.setDouble(5, materiel.getCoutUnitaire());
            pstmt.setDouble(6, materiel.getQuantite());
            pstmt.setDouble(7, materiel.getCoutTransport());
            pstmt.setDouble(8, materiel.getCoefficientQualite());

            pstmt.executeUpdate();
            System.out.println("Materiel inserted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
