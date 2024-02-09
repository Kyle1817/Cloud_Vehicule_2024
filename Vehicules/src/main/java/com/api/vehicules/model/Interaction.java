package com.api.vehicules.model;

import jakarta.persistence.*;

@Entity
@Table(name = "interaction")
public class Interaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_interaction")
    int id_interaction;
    @Column(name = "id_annonce")
    int id_annonce;
    @Column(name = "id_utilisateur")
    int id_utilisateur;
    @Column(name = "favoris")
    int favoris;

    public Interaction() {
    }

    public Interaction(int id_interaction, int id_annonce, int id_utilisateur, int favoris) {
        this.id_interaction = id_interaction;
        this.id_annonce = id_annonce;
        this.id_utilisateur = id_utilisateur;
        this.favoris = favoris;
    }

    public int getId_interaction() {
        return id_interaction;
    }

    public void setId_interaction(int id_interaction) {
        this.id_interaction = id_interaction;
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

    public int getFavoris() {
        return favoris;
    }

    public void setFavoris(int favoris) {
        this.favoris = favoris;
    }
}
