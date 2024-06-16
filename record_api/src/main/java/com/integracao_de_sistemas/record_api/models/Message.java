package com.integracao_de_sistemas.record_api.models;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_message")
public class Message implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;
    private Long userIdSend;
    private Long userIdReceive;

    public Message() {
    }
    public Message(Long id, String message, Long userIdSend, Long userIdReceive) {
        this.id = id;
        this.message = message;
        this.userIdSend = userIdSend;
        this.userIdReceive = userIdReceive;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public Long getUserIdSend() {
        return userIdSend;
    }
    public void setUserIdSend(Long userIdSend) {
        this.userIdSend = userIdSend;
    }
    public Long getUserIdReceive() {
        return userIdReceive;
    }
    public void setUserIdReceive(Long userIdReceive) {
        this.userIdReceive = userIdReceive;
    }
}
