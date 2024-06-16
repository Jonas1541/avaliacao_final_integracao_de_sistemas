package com.integracao_de_sistemas.receive_send_api.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.integracao_de_sistemas.receive_send_api.models.Message;
import com.integracao_de_sistemas.receive_send_api.service.MessageService;

import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping
    public ResponseEntity<Message> sendMessage(@RequestBody Message message, @RequestHeader("Authorization") String token) {
        try {
            Message sentMessage = messageService.sendMessage(message, token);
            return ResponseEntity.ok().body(sentMessage);
        } catch (RuntimeException e) {
            return ResponseEntity.status(401).build();
        }
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Message>> receiveMessages(@PathVariable Long userId, @RequestHeader("Authorization") String token) {
        try {
            List<Message> messages = messageService.receiveMessages(userId, token);
            return ResponseEntity.ok().body(messages);
        } catch (RuntimeException e) {
            return ResponseEntity.status(401).build();
        }
    }
}
