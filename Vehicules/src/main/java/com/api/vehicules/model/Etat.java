package com.api.vehicules.model;

import jakarta.persistence.*;

@Entity
@Table(name = "etat")
public class Etat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_etat")
    int id_etat;
    @Column(name = "nom_etat")
    String nom_etat;

    public Etat() {
    }

    public Etat(int id_etat, String nom_etat) {
        this.id_etat = id_etat;
        this.nom_etat = nom_etat;
    }

    public int getId_etat() {
        return id_etat;
    }

    public void setId_etat(int id_etat) {
        this.id_etat = id_etat;
    }

    public String getNom_etat() {
        return nom_etat;
    }

    public void setNom_etat(String nom_etat) {
        this.nom_etat = nom_etat;
    }
}
