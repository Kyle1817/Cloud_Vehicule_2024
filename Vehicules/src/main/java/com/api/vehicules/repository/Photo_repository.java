package com.api.vehicules.repository;

import com.api.vehicules.model.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Photo_repository extends JpaRepository<Photo, Integer> {

}
