package fr.diginamic.jdbc.dal;

import fr.diginamic.jdbc.entites.Fournisseur;

import java.sql.SQLException;
import java.util.List;

public interface FournisseurDao {
    List<Fournisseur> extraire() throws SQLException;
    void insert(Fournisseur fournisseur) throws SQLException;
    int upDate(String ancienNom, String nouveauNom) throws SQLException;
    boolean delete(Fournisseur fournisseur);
}
