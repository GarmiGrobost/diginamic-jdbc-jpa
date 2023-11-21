package fr.diginamic.jdbc;

import fr.diginamic.jdbc.dal.FournisseurDao;
import fr.diginamic.jdbc.dal.FournisseurDaoJdbc;

import java.sql.SQLException;

public class TestUpdateDao {
    public static void main(String[] args) {
        try {
            FournisseurDao fdao = new FournisseurDaoJdbc();
            fdao.upDate("La maison de la peinture", "La maison des peintures");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
