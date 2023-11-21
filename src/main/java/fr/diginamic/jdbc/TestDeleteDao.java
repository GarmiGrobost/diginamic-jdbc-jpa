package fr.diginamic.jdbc;

import fr.diginamic.jdbc.dal.FournisseurDao;
import fr.diginamic.jdbc.dal.FournisseurDaoJdbc;
import fr.diginamic.jdbc.entites.Fournisseur;

public class TestDeleteDao {
    public static void main(String[] args) {
        FournisseurDao fdao = new FournisseurDaoJdbc();
        fdao.delete(new Fournisseur("La maison des peintures"));
    }
}
