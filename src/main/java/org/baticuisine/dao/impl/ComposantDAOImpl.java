package org.baticuisine.dao.impl;

import org.baticuisine.config.DatabaseConnection;
import org.baticuisine.dao.ProjetDAO;
import org.baticuisine.entities.Projet;

import java.sql.Connection;
import java.sql.SQLException;

public class ComposantDAOImpl {
    private final Connection connection;
    {
        try {
            connection= DatabaseConnection.getInstance().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
