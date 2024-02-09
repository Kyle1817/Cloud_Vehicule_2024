package com.api.vehicules.model;

import jakarta.persistence.*;

@Entity
@Table(name = "photo")
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_photo")
    int id_photo;
    @Column(name = "lien_photo")
    String lien_photo;

    public Photo() {
    }

    public Photo(int id_photo, String lien_photo) {
        this.id_photo = id_photo;
        this.lien_photo = lien_photo;
    }

    public int getId_photo() {
        return id_photo;
    }

    public void setId_photo(int id_photo) {
        this.id_photo = id_photo;
    }

    public String getLien_photo() {
        return lien_photo;
    }

    public void setLien_photo(String lien_photo) {
        this.lien_photo = lien_photo;
    }
}
