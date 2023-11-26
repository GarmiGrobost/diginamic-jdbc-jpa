package fr.diginamic.jdbc.dal;

import fr.diginamic.jdbc.entites.Fournisseur;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class FournisseurDaoJdbc implements FournisseurDao {
    private static final String DB_URL;
    private static final String DB_USER;
    private static final String DB_PWD;

    static {
        ResourceBundle bundle = ResourceBundle.getBundle("db");
        DB_URL = bundle.getString("db.url");
        DB_USER = bundle.getString("db.user");
        DB_PWD = bundle.getString("db.password");

    }

    private static final String EXTRAIRE_QUERY = "SELECT ID, NOM FROM FOURNISSEUR";
    private static final String INSERT_QUERY = "INSERT INTO FOURNISSEUR (NOM) VALUES (?)";
    private static final String UPDATE_QUERY = "UPDATE FOURNISSEUR SET NOM = ? WHERE ID = ?";
    private static final String DELETE_QUERY = "DELETE FROM FOURNISSEUR WHERE NOM = ?";

    @Override
    public List<Fournisseur> extraire() throws SQLException {

        List<Fournisseur> fournisseursTrouves = new ArrayList<>();
        try (Connection connexion = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
             PreparedStatement preparedStatement = connexion.prepareStatement(EXTRAIRE_QUERY);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String nom = resultSet.getString("NOM");
                Fournisseur fournisseur = new Fournisseur(id, nom);
                fournisseursTrouves.add(fournisseur);
            }
        }
        return fournisseursTrouves;
    }

    @Override
    public void insert(Fournisseur fournisseur) throws SQLException {
        try (Connection connexion = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
             PreparedStatement preparedStatement = connexion.prepareStatement(INSERT_QUERY)) {
             preparedStatement.setString(1, fournisseur.getNom());
             preparedStatement.executeUpdate();
        } catch (SQLException e) {
             System.err.println(e.getMessage());
        }
    }

    @Override
    public int upDate(String ancienNom, String nouveauNom) throws SQLException {
        try (Connection connexion = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
             PreparedStatement preparedStatement = connexion.prepareStatement(UPDATE_QUERY)) {
             preparedStatement.setString(1, nouveauNom);
             preparedStatement.setInt(2, 5);
             preparedStatement.executeUpdate();
        } catch (SQLException e) {
             System.err.println(e.getMessage());
        }
        return 0;
    }

    @Override
    public boolean delete(Fournisseur fournisseur) {
        try (Connection connexion = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
             PreparedStatement preparedStatement = connexion.prepareStatement(DELETE_QUERY)) {
             preparedStatement.setString(1, fournisseur.getNom());
             preparedStatement.executeUpdate();
        } catch (SQLException e) {
             System.err.println(e.getMessage());
        }
        return false;
    }
}

