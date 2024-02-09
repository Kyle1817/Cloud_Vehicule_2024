package com.api.vehicules.model;

import jakarta.persistence.*;

@Entity
@Table(name = "admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_admin")
    int id_admin;
    @Column(name = "nom_admin")
    String nom_admin;
    @Column(name = "email")
    String email;
    @Column(name = "mdp")
    String mdp;

    public Admin(int id_admin, String nom_admin, String email, String mdp) {
        this.id_admin = id_admin;
        this.nom_admin = nom_admin;
        this.email = email;
        this.mdp = mdp;
    }

    public Admin() {
    }

    public int getId_admin() {
        return id_admin;
    }

    public void setId_admin(int id_admin) {
        this.id_admin = id_admin;
    }

    public String getNom_admin() {
        return nom_admin;
    }

    public void setNom_admin(String nom_admin) {
        this.nom_admin = nom_admin;
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
