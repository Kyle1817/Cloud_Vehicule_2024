package com.api.vehicules.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.vehicules.model.Message;
import com.api.vehicules.repository.MessageRepository;

@Service
public class Message_service {
    @Autowired
    private MessageRepository message_repository;

    public List<Message> getMessage(){
        return message_repository.findAll();
    }

    public Message insert(Message message){
        Message createTof = message_repository.save(message);
        return createTof;
    }

    public List<Message> getMessagebyId_utilisateur_des(Integer id_utilisateur_des){
        return message_repository.findByMessages(id_utilisateur_des);
    }

    // public Boolean notification(int id_utilisateur){
    //     Optional<Message> message = message_repository.findById(id_utilisateur);
    //     if(){

    //     }
    //     return true;
    // }
}
