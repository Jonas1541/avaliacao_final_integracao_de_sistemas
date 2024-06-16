package com.integracao_de_sistemas.record_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.integracao_de_sistemas.record_api.models.Message;

public interface MessageRepository extends JpaRepository<Message, Long>{
    
}
