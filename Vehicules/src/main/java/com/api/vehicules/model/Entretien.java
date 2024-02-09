package com.api.vehicules.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "entretien")
public class Entretien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_entretien")
    int id_entretien;
    @Column(name = "changement")
    String changement;
    @Column(name = "date_entretien")
    Date date_entretien;

    public Entretien() {
    }

    public Entretien(int id_entretien, String changement, Date date_entretien) {
        this.id_entretien = id_entretien;
        this.changement = changement;
        this.date_entretien = date_entretien;
    }

    public int getId_entretien() {
        return id_entretien;
    }

    public void setId_entretien(int id_entretien) {
        this.id_entretien = id_entretien;
    }

    public String getChangement() {
        return changement;
    }

    public void setChangement(String changement) {
        this.changement = changement;
    }

    public Date getDate_entretien() {
        return date_entretien;
    }

    public void setDate_entretien(Date date_entretien) {
        this.date_entretien = date_entretien;
    }
}
