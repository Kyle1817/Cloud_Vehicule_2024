package com.api.vehicules.service;

import com.api.vehicules.model.Categorie;
import com.api.vehicules.model.Entretien;
import com.api.vehicules.repository.Categorie_repository;
import com.api.vehicules.repository.Entretien_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Entretien_service {
    @Autowired
    private Entretien_repository entretien_repository;

    public List<Entretien> getAllEntretien(){
        return entretien_repository.findAll();
    }
    public Entretien createEntretien(Entretien entretien){
        Entretien createEntretien = entretien_repository.save(entretien);
        return createEntretien;
    }
}
