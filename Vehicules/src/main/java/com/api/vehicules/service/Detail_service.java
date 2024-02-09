package com.api.vehicules.service;

import com.api.vehicules.model.Annonce;
import com.api.vehicules.model.Categorie;
import com.api.vehicules.model.Detail;
import com.api.vehicules.model.Voiture;
import com.api.vehicules.repository.Categorie_repository;
import com.api.vehicules.repository.Detail_repository;
import com.api.vehicules.repository.Voiture_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class Detail_service {
    @Autowired
    private Detail_repository detail_repository;
    private Voiture_service voiture_service;
    private Annonce_service annonces;

    public List<Detail> getAllDetail(){
        return detail_repository.findAll();
    }
    public Detail createDetail(Detail detail)
    {
        Detail createDetail = detail_repository.save(detail);
        return createDetail;
    }

    public Optional<Detail> getDetailby(int id){
        return detail_repository.findById(id);
    }

    public Optional<Detail> getDetailbyIdVoiture(Voiture voiture){
        return detail_repository.findById(voiture.getId_detail());
    }

    public Optional<Detail> getDetailAnnonce(int id_annonce){
        Optional<Annonce> annonce = annonces.getAnnonceById(id_annonce);
        Optional<Voiture> v = voiture_service.getVoitureby(annonce.get().getId_voiture());
        Optional<Detail> detail = this.getDetailby(v.get().getId_detail());
        return detail;
    }
}
