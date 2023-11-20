package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class TestUpdate {

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
        try (Connection connexion = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
             Statement statement = connexion.createStatement() ){
            int nb = statement.executeUpdate("UPDATE FOURNISSEUR SET NOM = 'La maison des peintures' WHERE ID = 4");
            System.out.println(nb);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
