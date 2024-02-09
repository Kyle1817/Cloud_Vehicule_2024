package com.api.vehicules.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "detail")
public class Detail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detail")
    int id_detail;
    @Column(name = "nom_modele")
    String nom_modele;
    @Column(name = "puissance")
    float puissance;
    @Column(name = "carburant")
    String carburant;
    @Column(name = "nom_moteur")
    String nom_moteur;
    @Column(name = "id_etat")
    int id_etat;
    @Column(name = "id_entretien")
    int id_entretien;
    @Column(name = "prix")
    double prix;
    @Column(name = "commission")
    float commission;
    @Column(name = "kilometrage")
    int kilometrage;
    @Column(name = "boite_vitesse")
    String boite_vitesse;
    @Column(name = "date_sortie")
    Date date_sortie;
    @Column(name = "commentaire")
    String commentaire;

    public Detail() {
    }

    public Detail(int id_detail, String nom_modele, float puissance, String carburant, String nom_moteur, int id_etat, int id_entretien, double prix, float commission, int kilometrage, String boite_vitesse, Date date_sortie, String commentaire) {
        this.id_detail = id_detail;
        this.nom_modele = nom_modele;
        this.puissance = puissance;
        this.carburant = carburant;
        this.nom_moteur = nom_moteur;
        this.id_etat = id_etat;
        this.id_entretien = id_entretien;
        this.prix = prix;
        this.commission = commission;
        this.kilometrage = kilometrage;
        this.boite_vitesse = boite_vitesse;
        this.date_sortie = date_sortie;
        this.commentaire = commentaire;
    }

    public int getId_detail() {
        return id_detail;
    }

    public void setId_detail(int id_detail) {
        this.id_detail = id_detail;
    }

    public String getNom_modele() {
        return nom_modele;
    }

    public void setNom_modele(String nom_modele) {
        this.nom_modele = nom_modele;
    }

    public float getPuissance() {
        return puissance;
    }

    public void setPuissance(float puissance) {
        this.puissance = puissance;
    }

    public String getCarburant() {
        return carburant;
    }

    public void setCarburant(String carburant) {
        this.carburant = carburant;
    }

    public String getNom_moteur() {
        return nom_moteur;
    }

    public void setNom_moteur(String nom_moteur) {
        this.nom_moteur = nom_moteur;
    }

    public int getId_etat() {
        return id_etat;
    }

    public void setId_etat(int id_etat) {
        this.id_etat = id_etat;
    }

    public int getId_entretien() {
        return id_entretien;
    }

    public void setId_entretien(int id_entretien) {
        this.id_entretien = id_entretien;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public float getCommission() {
        return commission;
    }

    public void setCommission(float commission) {
        this.commission = commission;
    }

    public int getKilometrage() {
        return kilometrage;
    }

    public void setKilometrage(int kilometrage) {
        this.kilometrage = kilometrage;
    }

    public String getBoite_vitesse() {
        return boite_vitesse;
    }

    public void setBoite_vitesse(String boite_vitesse) {
        this.boite_vitesse = boite_vitesse;
    }

    public Date getDate_sortie() {
        return date_sortie;
    }

    public void setDate_sortie(Date date_sortie) {
        this.date_sortie = date_sortie;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }
}
