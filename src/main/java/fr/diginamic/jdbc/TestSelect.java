package fr.diginamic.jdbc;
import fr.diginamic.jdbc.entites.Fournisseur;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class TestSelect {
    private static final String DB_URL;
    private static final String DB_USER;
    private static final String DB_PWD;

    static {
        ResourceBundle bundle = ResourceBundle.getBundle("db");
        DB_URL= bundle.getString("db.url");
        DB_USER=bundle.getString("db.user");
        DB_PWD=bundle.getString("db.password");

    }
    public static void main(String[] args) {
        List<Fournisseur> fournisseurs = new ArrayList<>();
        try (Connection connexion = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
             Statement statement = connexion.createStatement();
             ResultSet resultSet= statement.executeQuery("SELECT ID, NOM FROM FOURNISSEUR")){
            while(resultSet.next()){
                int id = resultSet.getInt("ID");
                String nom = resultSet.getString("NOM");
                Fournisseur fournisseur = new Fournisseur(id, nom);
               fournisseurs.add(fournisseur);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        for (Fournisseur item: fournisseurs) {
            System.out.println(item);
        }
    }
}
