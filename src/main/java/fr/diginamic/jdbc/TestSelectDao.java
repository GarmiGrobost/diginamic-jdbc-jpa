package fr.diginamic.jdbc;

import fr.diginamic.jdbc.dal.FournisseurDao;
import fr.diginamic.jdbc.dal.FournisseurDaoJdbc;
import fr.diginamic.jdbc.entites.Fournisseur;

import java.sql.SQLException;
import java.util.List;

public class TestSelectDao {
    public static void main(String[] args) {
        FournisseurDao fdao = new FournisseurDaoJdbc();
        try {
            List<Fournisseur> fournisseurs = fdao.extraire();
            for (Fournisseur item: fournisseurs) {
                System.out.println(item);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
