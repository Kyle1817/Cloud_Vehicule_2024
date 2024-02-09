package com.api.vehicules.service;

import com.api.vehicules.model.Categorie;
import com.api.vehicules.model.Photo;
import com.api.vehicules.repository.Categorie_repository;
import com.api.vehicules.repository.Photo_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Photo_service {
    @Autowired
    private Photo_repository photo_repository;

    public List<Photo> getAllPhoto(){
        return photo_repository.findAll();
    }
    public Photo createPhoto(Photo photo)
    {
        Photo createTof = photo_repository.save(photo);
        return createTof;
    }
}
