package fr.diginamic.jdbc;

import fr.diginamic.jdbc.dal.FournisseurDao;
import fr.diginamic.jdbc.dal.FournisseurDaoJdbc;
import fr.diginamic.jdbc.entites.Fournisseur;

import java.sql.SQLException;

public class TestInsertionDao {
    public static void main(String[] args) {

        try {
            FournisseurDao fdao = new FournisseurDaoJdbc();
            fdao.insert(new Fournisseur("L'espace création"));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
