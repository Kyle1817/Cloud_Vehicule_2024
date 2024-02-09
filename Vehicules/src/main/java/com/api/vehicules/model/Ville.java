package com.api.vehicules.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ville")
public class Ville {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ville")
    int id_ville;
    @Column(name = "nom")
    String nom;

    public Ville() {
    }

    public Ville(int id_ville, String nom) {
        this.id_ville = id_ville;
        this.nom = nom;
    }

    public int getId_ville() {
        return id_ville;
    }

    public void setId_ville(int id_ville) {
        this.id_ville = id_ville;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
