package com.api.vehicules.repository;

import com.api.vehicules.model.Annonce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Annonce_repository extends JpaRepository<Annonce, Integer> {

}
