package com.pibitaim.us.msjavagerenciadorusuarios.service.impl;

import com.pibitaim.us.msjavagerenciadorusuarios.entity.Email;
import com.pibitaim.us.msjavagerenciadorusuarios.repository.EmailRepository;
import com.pibitaim.us.msjavagerenciadorusuarios.service.interfaces.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private EmailRepository emailRepository;

    @Override
    public Page<Email> findAll(Pageable paginacao) {
        return emailRepository.findAll(paginacao);
    }
}
