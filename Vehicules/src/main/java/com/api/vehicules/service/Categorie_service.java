package com.api.vehicules.service;

import com.api.vehicules.model.Categorie;
import com.api.vehicules.model.Marque;
import com.api.vehicules.model.Utilisateur;
import com.api.vehicules.repository.Categorie_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Categorie_service {
    @Autowired
    private Categorie_repository categorie_repository;

    public List<Categorie> getAllCategorie(){
        return categorie_repository.findAll();
    }
    public Categorie createCategorie(Categorie categorie)
    {
        Categorie createCat = categorie_repository.save(categorie);
        return createCat;
    }
}
