package com.pibitaim.us.msjavagerenciadorusuarios.service.interfaces;

import com.pibitaim.us.msjavagerenciadorusuarios.entity.Email;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmailService {

    Page<Email> findAll(Pageable paginacao);

}
