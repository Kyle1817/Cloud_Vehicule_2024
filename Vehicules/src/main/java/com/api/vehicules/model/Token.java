package com.api.vehicules.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "token")
public class Token {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "token")
    private String token;
    @Column(name = "cle")
    private String cle;
    @Column(name = "datecreation")
    private Date datecreation;
    @Column(name = "date_expiration")
    private Date date_expiration;

    public Token(){
    }

    public Token(Integer id, String token, String cle, Date datecreation, Date date_expiration) {
        this.id = id;
        this.token = token;
        this.cle = cle;
        this.datecreation = datecreation;
        this.date_expiration = date_expiration;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getCle() {
        return cle;
    }

    public void setCle(String cle) {
        this.cle = cle;
    }

    public Date getDatecreation() {
        return datecreation;
    }

    public void setDatecreation(Date datecreation) {
        this.datecreation = datecreation;
    }

    public Date getDate_expiration() {
        return date_expiration;
    }

    public void setDate_expiration(Date date_expiration) {
        this.date_expiration = date_expiration;
    }
}
