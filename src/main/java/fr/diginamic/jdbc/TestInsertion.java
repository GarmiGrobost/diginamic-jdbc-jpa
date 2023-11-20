package fr.diginamic.jdbc;

import java.nio.channels.ScatteringByteChannel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class TestInsertion {
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
            int nb = statement.executeUpdate("INSERT INTO FOURNISSEUR (NOM) VALUES ('La maison de la peinture')");
            System.out.println(nb);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
