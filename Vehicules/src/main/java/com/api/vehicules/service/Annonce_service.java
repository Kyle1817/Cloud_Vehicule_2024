package com.api.vehicules.service;

import com.api.vehicules.model.Annonce;
import com.api.vehicules.repository.Annonce_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class Annonce_service {
    @Autowired
    private Annonce_repository annonce_repository;

    public List<Annonce> getAllAnnonce(){
        return annonce_repository.findAll();
    }
    public Annonce createAnnonce(Annonce annonce){
        Annonce create = annonce_repository.save(annonce);
        return create;
    }
    public Optional<Annonce> getAnnonceById(int id){
        return annonce_repository.findById(id);
    }
    public Annonce updateAnnonce(Annonce annonce){
        return annonce_repository.save(annonce);
    }
    public void deleteAnnonce(int id){
        annonce_repository.deleteById(id);
    }

    public List<Annonce> GetAnnoncebyAccept_annonce(int accepte_annonce){
        List<Annonce> ans = new ArrayList<>();
        List<Annonce> source = this.getAllAnnonce();
        Annonce annonce = new Annonce();
        for(int i = 0; i<source.size(); i++)
        {
            if(source.get(i).getAccepte_annonce() == accepte_annonce){
                annonce = source.get(i);
                ans.add(annonce);
            }
        }
        return ans;
    }

}
