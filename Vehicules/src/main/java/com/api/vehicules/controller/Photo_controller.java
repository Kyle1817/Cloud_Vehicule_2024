package com.api.vehicules.controller;

import com.api.vehicules.model.Photo;
import com.api.vehicules.service.Photo_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/photo/")
@CrossOrigin
public class Photo_controller {
    @Autowired
    Photo_service photo_service;

    @GetMapping("all_photo")
    public List<Photo> getListPhoto(){
        return photo_service.getAllPhoto();
    }
    @PostMapping("/add_photo")
    public ResponseEntity<Photo> createPhoto(@RequestBody Photo photo){
        Photo create_photo = photo_service.createPhoto(photo);
        return new ResponseEntity<>(create_photo, HttpStatus.CREATED);
    }
}
