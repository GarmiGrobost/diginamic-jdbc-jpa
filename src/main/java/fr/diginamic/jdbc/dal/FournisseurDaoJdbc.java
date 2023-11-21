package fr.diginamic.jdbc.dal;

import fr.diginamic.jdbc.entites.Fournisseur;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class FournisseurDaoJdbc implements FournisseurDao{
    private static final String DB_URL;
    private static final String DB_USER;
    private static final String DB_PWD;

    static {
        ResourceBundle bundle = ResourceBundle.getBundle("db");
        DB_URL= bundle.getString("db.url");
        DB_USER=bundle.getString("db.user");
        DB_PWD=bundle.getString("db.password");

    }

    private static final String EXTRAIRE_QUERY = "SELECT ID, NOM FROM FOURNISSEUR";
    private static final String INSERT_QUERY = "INSERT INTO FOURNISSEUR (NOM) VALUES ('%s')";
    private static final String UPDATE_QUERY = "UPDATE FOURNISSEUR SET NOM = '%s' WHERE ID = 5";
    private static final String DELETE_QUERY = "DELETE FROM FOURNISSEUR WHERE NOM = '%s'";
    @Override
    public List<Fournisseur> extraire() throws SQLException {

        List<Fournisseur> fournisseursTrouves = new ArrayList<>();
        try (Connection connexion = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
             Statement statement = connexion.createStatement();
             ResultSet resultSet= statement.executeQuery(EXTRAIRE_QUERY)){
            while(resultSet.next()){
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
             Statement statement = connexion.createStatement() ){
             statement.executeUpdate(String.format(INSERT_QUERY, fournisseur.getNom()));
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public int upDate(String ancienNom, String nouveauNom) throws SQLException  {
        try (Connection connexion = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
             Statement statement = connexion.createStatement() ){
            statement.executeUpdate(UPDATE_QUERY);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return 0;
    }

    @Override
    public boolean delete(Fournisseur fournisseur){
        try (Connection connexion = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
             Statement statement = connexion.createStatement() ){
             statement.executeUpdate(String.format(DELETE_QUERY, fournisseur.getNom()));
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }
}

