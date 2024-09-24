package org.baticuisine.dao.impl;

import org.baticuisine.config.DatabaseConnection;
import org.baticuisine.dao.ClientDAO;
import org.baticuisine.entities.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import  static  org.baticuisine.utils.loggerUtil.error;

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

            error("Error adding client"+ e);
        }
    }


    @Override
    public List<Client> getAllClients() {
        List<Client> clients = new ArrayList<>();
        String sql = "SELECT id, nom, adresse, telephone, estProfessionnel FROM client";

        try (PreparedStatement pstmt = connection.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Client client = new Client();
                client.setId(rs.getInt("id"));
                client.setNom(rs.getString("nom"));
                client.setAdresse(rs.getString("adresse"));
                client.setTelephone(rs.getString("telephone"));
                client.setEstProfessionnel(rs.getBoolean("estProfessionnel"));

                clients.add(client);
            }
        } catch (SQLException e) {
            error("Error retrieving clients"+ e);
        }

        return clients;
    }


}
