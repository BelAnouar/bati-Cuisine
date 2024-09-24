package org.baticuisine.dao.impl;

import org.baticuisine.config.DatabaseConnection;
import org.baticuisine.dao.MaterielDao;
import org.baticuisine.entities.Materiel;
import org.baticuisine.enums.TypeComposant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    @Override
    public List<Materiel> getAllMateriel() {
        List<Materiel> materiels = new ArrayList<>();
        String sql = "SELECT m.id, m.nom, m.typecomposant, m.tauxTVA, m.coutunitaire, m.quantite, m.couttransport, m.coefficientqualite, p.id as projetId, p.nom as projetNom FROM materiel m LEFT JOIN projet p ON m.projetid = p.id";

        try (PreparedStatement pstmt = connection.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Materiel materiel = new Materiel();
                materiel.setId(rs.getInt("id"));
                materiel.setNom(rs.getString("nom"));
                materiel.setTypeComposant(TypeComposant.valueOf(rs.getString("typecomposant")));
                materiel.setTauxTVA(rs.getDouble("tauxTVA"));
                materiel.getProjet().setId(rs.getInt("projetid"));
                materiel.setCoutUnitaire(rs.getDouble("coutunitaire"));
                materiel.setQuantite(rs.getDouble("quantite"));
                materiel.setCoutTransport(rs.getDouble("couttransport"));
                materiel.setCoefficientQualite(rs.getDouble("coefficientqualite"));

                materiels.add(materiel);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all materiels", e);
        }

        return materiels;
    }

    @Override
    public List<Materiel> getMaterielByIdProjet(int id) {
        List<Materiel> materiels = new ArrayList<>();
        String query = "SELECT * FROM materiel WHERE projetid = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Materiel materiel = new Materiel();
                materiel.setId(rs.getInt("id"));
                materiel.setNom(rs.getString("nom"));
                materiel.setTypeComposant(TypeComposant.valueOf(rs.getString("typecomposant")));
                materiel.setTauxTVA(rs.getDouble("tauxTVA"));
                materiel.setCoutUnitaire(rs.getDouble("coutunitaire"));
                materiel.setQuantite(rs.getDouble("quantite"));
                materiel.setCoutTransport(rs.getDouble("couttransport"));
                materiel.setCoefficientQualite(rs.getDouble("coefficientqualite"));
                materiels.add(materiel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return materiels;
    }

}