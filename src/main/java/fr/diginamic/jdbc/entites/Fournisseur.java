package fr.diginamic.jdbc.entites;

import java.util.ArrayList;

public class Fournisseur {

    private int id;
    private String nom;

    public Fournisseur() {
    }

    public Fournisseur(String nom) {
        this.nom = nom;
    }

    public Fournisseur(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
