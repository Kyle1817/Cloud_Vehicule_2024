package com.api.vehicules.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "messagerie")
public class Message {
    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    int id_message;
    String messages;
    int id_utilisateur_em;
    int id_utilisateur_des;

    public Message(int id_message, String messages, int id_utilisateur_em, int id_utilisateur_des) {
        this.id_message = id_message;
        this.messages = messages;
        this.id_utilisateur_em = id_utilisateur_em;
        this.id_utilisateur_des = id_utilisateur_des;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public int getId_message() {
        return id_message;
    }
    public void setId_message(int id_message) {
        this.id_message = id_message;
    }
    public String getMessages() {
        return messages;
    }
    public void setMessages(String messages) {
        this.messages = messages;
    }
    public int getId_utilisateur_em() {
        return id_utilisateur_em;
    }
    public void setId_utilisateur_em(int id_utilisateur_em) {
        this.id_utilisateur_em = id_utilisateur_em;
    }
    public int getId_utilisateur_des() {
        return id_utilisateur_des;
    }
    public void setId_utilisateur_des(int id_utilisateur_des) {
        this.id_utilisateur_des = id_utilisateur_des;
    }

    
}
