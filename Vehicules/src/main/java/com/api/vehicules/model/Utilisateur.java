package com.api.vehicules.model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

@Entity
@Table(name = "utilisateur")
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_utilisateur")
    int id_utilisateur;
    @Column(name = "nom_utilisateur")
    String nom;
    @Column(name = "prenom_utilisateur")
    String prenom;
    @Column(name = "ville")
    String ville;
    @Column(name = "contact")
    String contact;
    @Column(name = "mail")
    String email;
    @Column(name = "mdp")
    String mdp;

    public Utilisateur() {
    }

    public Utilisateur(int id_utilisateur, String nom, String prenom, String ville, String contact, String email, String mdp) {
        this.id_utilisateur = id_utilisateur;
        this.nom = nom;
        this.prenom = prenom;
        this.ville = ville;
        this.contact = contact;
        this.email = email;
        this.mdp = mdp;
    }
    public Utilisateur(String email,String mdp){
        this.email = email;
        this.mdp = mdp;
    }

    public int getId_utilisateur() {
        return id_utilisateur;
    }

    public void setId_utilisateur(int id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
}
