package com.integracao_de_sistemas.record_api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.integracao_de_sistemas.record_api.models.Message;
import com.integracao_de_sistemas.record_api.services.MessageService;

@RestController
@RequestMapping("/record")
public class MessageController {

    @Autowired
    private MessageService recordService;

    @PostMapping
    public ResponseEntity<Message> recordMessage(@RequestBody Message message) {
        Message recordedMessage = recordService.recordMessage(message);
        return ResponseEntity.status(HttpStatus.CREATED).body(recordedMessage);
    }

    // Adicionar outros endpoints de consulta de histórico se necessário
}
