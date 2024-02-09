package com.api.vehicules.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "annonce")
public class Annonce {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_annonce")
    int id_annonce;
    @Column(name = "id_utilisateur")
    int id_utilisateur;
    @Column(name = "id_voiture")
    int id_voiture;
    @Column(name = "date_annonce")
    Date date_annonce;
    @Column(name = "accepte_annonce")
    int accepte_annonce;

    public Annonce() {
    }

    public Annonce(int id_annonce, int id_utilisateur, int id_voiture, Date date_annonce, int accept_annonce) {
        this.id_annonce = id_annonce;
        this.id_utilisateur = id_utilisateur;
        this.id_voiture = id_voiture;
        this.date_annonce = date_annonce;
        this.accepte_annonce = accept_annonce;
    }

    public int getId_annonce() {
        return id_annonce;
    }

    public void setId_annonce(int id_annonce) {
        this.id_annonce = id_annonce;
    }

    public int getId_utilisateur() {
        return id_utilisateur;
    }

    public void setId_utilisateur(int id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    public int getId_voiture() {
        return id_voiture;
    }

    public void setId_voiture(int id_voiture) {
        this.id_voiture = id_voiture;
    }

    public Date getDate_annonce() {
        return date_annonce;
    }

    public void setDate_annonce(Date date_annonce) {
        this.date_annonce = date_annonce;
    }

    public int getAccepte_annonce() {
        return accepte_annonce;
    }

    public void setAccepte_annonce(int accept_annonce) {
        this.accepte_annonce = accept_annonce;
    }
}
