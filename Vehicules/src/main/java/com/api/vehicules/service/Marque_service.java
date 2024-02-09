package com.api.vehicules.service;

import com.api.vehicules.model.Interaction;
import com.api.vehicules.model.Marque;
import com.api.vehicules.model.Voiture;
import com.api.vehicules.repository.Marque_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Marque_service {
    @Autowired
    private Marque_repository marque_repository;
    public List<Marque> getAllMarque(){
        return marque_repository.findAll();
    }
    public Marque createMarque(Marque marque)
    {
        Marque createMarque = marque_repository.save(marque);
        return createMarque;
    }
    public Optional<Marque> getMarqueby(int id){
        return marque_repository.findById(id);
    }
}

