package com.integracao_de_sistemas.record_api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.integracao_de_sistemas.record_api.models.Message;
import com.integracao_de_sistemas.record_api.repositories.MessageRepository;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public Message recordMessage(Message message) {
        return messageRepository.save(message);
    }

    // Adicionar outros métodos de consulta de histórico se necessário
}
