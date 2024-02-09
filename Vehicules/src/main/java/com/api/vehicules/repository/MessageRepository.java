package com.api.vehicules.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.api.vehicules.model.Message;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends MongoRepository<Message , Integer>{
    List<Message> findByMessages(int id_utilisateur_des);
}
