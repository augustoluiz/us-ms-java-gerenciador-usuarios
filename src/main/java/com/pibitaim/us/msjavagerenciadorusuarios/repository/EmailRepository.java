package com.pibitaim.us.msjavagerenciadorusuarios.repository;

import com.pibitaim.us.msjavagerenciadorusuarios.entity.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<Email, String> {
}
