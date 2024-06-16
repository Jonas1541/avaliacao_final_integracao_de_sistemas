package com.integracao_de_sistemas.receive_send_api.models;

import java.io.Serializable;

public class Message implements Serializable {
    private static final long serialVersionUID = 1L;
    
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

