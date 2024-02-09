package com.api.vehicules.repository;

import com.api.vehicules.model.Token;
import com.api.vehicules.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Token_repository extends JpaRepository<Token, Integer> {

}
