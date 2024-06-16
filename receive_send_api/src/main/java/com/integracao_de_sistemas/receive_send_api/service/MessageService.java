package com.integracao_de_sistemas.receive_send_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.integracao_de_sistemas.receive_send_api.models.Message;

import java.util.Arrays;
import java.util.List;

@Service
public class MessageService {

    @Autowired
    private RestTemplate restTemplate;

    private static final String AUTH_API_URL = "http://localhost:8081/auth";
    private static final String RECORD_API_URL = "http://localhost:8082/record";

    public Message sendMessage(Message message, String token) {
        // Validate token with Auth-API
        if (!validateToken(token)) {
            throw new RuntimeException("Invalid token");
        }

        // Send message to Record-API
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);
        HttpEntity<Message> request = new HttpEntity<>(message, headers);
        ResponseEntity<Message> response = restTemplate.postForEntity(RECORD_API_URL + "/messages", request, Message.class);
        return response.getBody();
    }

    public List<Message> receiveMessages(Long userId, String token) {
        // Validate token with Auth-API
        if (!validateToken(token)) {
            throw new RuntimeException("Invalid token");
        }

        // Retrieve messages from Record-API
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);
        HttpEntity<Void> request = new HttpEntity<>(headers);
        ResponseEntity<Message[]> response = restTemplate.exchange(RECORD_API_URL + "/messages/" + userId, HttpMethod.GET, request, Message[].class);
        return Arrays.asList(response.getBody());
    }

    private boolean validateToken(String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);
        HttpEntity<Void> request = new HttpEntity<>(headers);
        ResponseEntity<Boolean> response = restTemplate.exchange(AUTH_API_URL + "/validate", HttpMethod.GET, request, Boolean.class);
        return response.getBody() != null && response.getBody();
    }
}
