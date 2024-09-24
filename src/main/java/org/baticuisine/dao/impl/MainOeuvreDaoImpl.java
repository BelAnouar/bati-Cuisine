package org.baticuisine.dao.impl;

import org.baticuisine.config.DatabaseConnection;
import org.baticuisine.dao.MainOeuvreDao;
import org.baticuisine.entities.MainOeuvre;
import org.baticuisine.enums.TypeComposant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.baticuisine.utils.loggerUtil.error;
import static org.baticuisine.utils.loggerUtil.info;

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
          info("MainOeuvre inserted successfully!");
        } catch (SQLException e) {
            error("Error adding MainOeuvre"+ e);
        }
    }

    @Override
    public List<MainOeuvre> getAllMainOeuvre() {
        List<MainOeuvre> mainOeuvres = new ArrayList<>();
        String sql = "SELECT mo.id, mo.nom, mo.typecomposant, mo.tauxhoraire, mo.heurestravail, mo.productiviteouvrier, p.id as projetId, p.nom as projetNom FROM maindoeuvre mo LEFT JOIN projet p ON mo.projetid = p.id";

        try (PreparedStatement pstmt = connection.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                MainOeuvre mainOeuvre = new MainOeuvre();
                mainOeuvre.setId(rs.getInt("id"));
                mainOeuvre.setNom(rs.getString("nom"));
                mainOeuvre.setTypeComposant(TypeComposant.valueOf(rs.getString("typecomposant")));
                mainOeuvre.setTauxHoraire(rs.getDouble("tauxhoraire"));
                mainOeuvre.setTauxTVA(rs.getDouble("tauxTVA"));
                mainOeuvre.getProjet().setId(rs.getInt("projetid"));
                mainOeuvre.setHeuresTravail(rs.getDouble("heurestravail"));
                mainOeuvre.setProductiviteOuvrier(rs.getDouble("productiviteouvrier"));

                mainOeuvres.add(mainOeuvre);
            }
        } catch (SQLException e) {
            error("Error retrieving all main oeuvres"+ e);
        }

        return mainOeuvres;
    }

    @Override
    public List<MainOeuvre> getMainOeuvreByIdProjet(int id) {
        List<MainOeuvre> mainOeuvres = new ArrayList<>();
        String query = "SELECT * FROM mainDoeuvre WHERE projetid = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                MainOeuvre mainOeuvre = new MainOeuvre();
                mainOeuvre.setId(resultSet.getInt("id"));
                mainOeuvre.setNom(resultSet.getString("nom"));
                mainOeuvre.setTypeComposant(TypeComposant.valueOf(resultSet.getString("typecomposant")));
                mainOeuvre.setTauxHoraire(resultSet.getDouble("tauxhoraire"));
                mainOeuvre.setTauxTVA(resultSet.getDouble("tauxTVA"));
                mainOeuvre.setHeuresTravail(resultSet.getDouble("heurestravail"));
                mainOeuvre.setProductiviteOuvrier(resultSet.getDouble("productiviteouvrier"));
                mainOeuvres.add(mainOeuvre);
            }
        } catch (SQLException e) {
            error("Error get  MainDoeuvre"+ e);
        }
        return mainOeuvres;
    }

}