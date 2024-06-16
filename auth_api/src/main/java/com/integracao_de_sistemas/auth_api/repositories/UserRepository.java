package com.integracao_de_sistemas.auth_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.integracao_de_sistemas.auth_api.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    //Se não funcionar tem que ser Login
    UserDetails findByEmail(String email);
}
