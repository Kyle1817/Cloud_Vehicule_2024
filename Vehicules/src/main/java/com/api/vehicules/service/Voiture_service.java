package com.api.vehicules.service;

import com.api.vehicules.model.Categorie;
import com.api.vehicules.model.Voiture;
import com.api.vehicules.repository.Categorie_repository;
import com.api.vehicules.repository.Voiture_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Voiture_service {
    @Autowired
    private Voiture_repository voiture_repository;

    public List<Voiture> getAllVoiture(){
        return voiture_repository.findAll();
    }
    public Voiture createVoiture(Voiture voiture)
    {
        Voiture createV = voiture_repository.save(voiture);
        return createV;
    }

    public Optional<Voiture> getVoitureby(int id){
        return voiture_repository.findById(id);
    }
}
