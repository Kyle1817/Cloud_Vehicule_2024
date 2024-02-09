package com.api.vehicules.service;

import com.api.vehicules.model.Categorie;
import com.api.vehicules.model.Etat;
import com.api.vehicules.repository.Categorie_repository;
import com.api.vehicules.repository.Etat_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Etat_service {
    @Autowired
    private Etat_repository etat_repository;
    public List<Etat> getAllEtat(){
        return etat_repository.findAll();
    }
    public Etat createEtat(Etat etat){
        Etat createEtat = etat_repository.save(etat);
        return createEtat;
    }
}
