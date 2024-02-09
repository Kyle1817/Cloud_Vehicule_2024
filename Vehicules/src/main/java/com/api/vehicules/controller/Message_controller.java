package com.api.vehicules.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.vehicules.model.Message;
import com.api.vehicules.service.Message_service;

@RestController
@RequestMapping("api/message/")
@CrossOrigin
public class Message_controller {
    @Autowired
    Message_service message_service;

    @GetMapping("all_message")
    public List<Message> getMessage(){
        return message_service.getMessage();
    }

    @GetMapping("message_id/{id_ut_des}")
    public List<Message> getMessageby_utilisateur(@PathVariable int id_ut_des){
        return message_service.getMessagebyId_utilisateur_des(id_ut_des);
    }
}
