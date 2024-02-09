package com.api.vehicules.controller;

import com.api.vehicules.model.Detail;
import com.api.vehicules.service.Detail_service;
import com.api.vehicules.service.Voiture_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("api/detail/")
@CrossOrigin
public class Detail_controller {
    @Autowired
    Detail_service detail_service;
    Voiture_service voiture_service;

    @GetMapping("all_detail")
    public List<Detail> getListDetail(){
        return detail_service.getAllDetail();
    }

    @PostMapping("/add_detail")
    public ResponseEntity<Detail> createDetail(@RequestBody Detail detail){
        Detail create_detail = detail_service.createDetail(detail);
        return new ResponseEntity<>(create_detail, HttpStatus.CREATED);
    }

    @GetMapping("/{id_detail}")
    public Optional<Detail> getDetailby(int id_detail){
        return detail_service.getDetailby(id_detail);
    }

    @GetMapping("/detail_annonce/{id_annonce}")
    public Optional<Detail> getDetailAnnonce(int id_annonce){
        return detail_service.getDetailby(id_annonce);
    }

    @GetMapping("/detail_parvoiture/{id_voiture}")
    public Optional<Detail> getdetailvoiture(int id_voiture) {
        return detail_service.getDetailbyIdVoiture(voiture_service.getVoitureby(id_voiture).get());
    }

}
