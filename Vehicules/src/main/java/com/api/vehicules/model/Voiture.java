package com.api.vehicules.model;

import jakarta.persistence.*;

@Entity
@Table(name = "voiture")
public class Voiture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_voiture")
    int id_voiture;
    @Column(name = "id_categorie")
    int id_categorie;
    @Column(name = "id_marque")
    int id_marque;
    @Column(name = "id_detail")
    int id_detail;
    @Column(name = "id_photo")
    int id_photo;
    @Column(name = "disponibilite")
    int disponibilite;

    public Voiture() {
    }

    public Voiture(int id_voiture, int id_categorie, int id_marque, int id_detail, int id_photo, int disponibilite) {
        this.id_voiture = id_voiture;
        this.id_categorie = id_categorie;
        this.id_marque = id_marque;
        this.id_detail = id_detail;
        this.id_photo = id_photo;
        this.disponibilite = disponibilite;
    }

    public int getId_voiture() {
        return id_voiture;
    }

    public void setId_voiture(int id_voiture) {
        this.id_voiture = id_voiture;
    }

    public int getId_categorie() {
        return id_categorie;
    }

    public void setId_categorie(int id_categorie) {
        this.id_categorie = id_categorie;
    }

    public int getId_marque() {
        return id_marque;
    }

    public void setId_marque(int id_marque) {
        this.id_marque = id_marque;
    }

    public int getId_detail() {
        return id_detail;
    }

    public void setId_detail(int id_detail) {
        this.id_detail = id_detail;
    }

    public int getId_photo() {
        return id_photo;
    }

    public void setId_photo(int id_photo) {
        this.id_photo = id_photo;
    }

    public int getDisponibilite() {
        return disponibilite;
    }

    public void setDisponibilite(int disponibilite) {
        this.disponibilite = disponibilite;
    }
}
