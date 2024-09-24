package org.baticuisine.dao.impl;

import org.baticuisine.config.DatabaseConnection;
import org.baticuisine.dao.ProjetDAO;
import org.baticuisine.entities.Projet;
import org.baticuisine.enums.Etat;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.baticuisine.utils.loggerUtil.error;

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
    @Override
    public List<Projet> getAllProjects() {
        List<Projet> projets = new ArrayList<>();
        String query = "SELECT id, nomprojet, surface,etatProjet ,idclient FROM projet";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                Projet projet = new Projet();
                projet.setId(resultSet.getInt("id"));
                projet.setNomProjet(resultSet.getString("nomprojet"));
                projet.setSurface(resultSet.getDouble("surface"));

                projet.setEtatProjet(Etat.valueOf(resultSet.getString("etatProjet")));
                projets.add(projet);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return projets;
    }

    @Override
    public void updateProject(int projectId, double coutTotal, double margeBeneficiaire) {
        String updateQuery = "UPDATE projet SET couttotal = ?, margebeneficiaire = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(updateQuery)) {
            stmt.setDouble(1, coutTotal);
            stmt.setDouble(2, margeBeneficiaire);
            stmt.setInt(3, projectId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            error("Erreur lors de la mise à jour du projet : " + e.getMessage());

        }
    }

    @Override
    public void updateEtatProject(int projectId, Etat etat) {
        String updateQuery = "UPDATE projet SET etatprojet = ?::etat WHERE id = ?";
        try (
             PreparedStatement stmt = connection.prepareStatement(updateQuery)) {
            stmt.setObject(1, etat.name());
            stmt.setInt(2, projectId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            error("Erreur lors de la mise à jour du projet : " + e.getMessage());

        }
    }

}
