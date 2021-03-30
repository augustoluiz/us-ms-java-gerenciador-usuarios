package com.pibitaim.us.msjavagerenciadorusuarios.service.impl;

import com.pibitaim.us.msjavagerenciadorusuarios.entity.Telefone;
import com.pibitaim.us.msjavagerenciadorusuarios.repository.TelefoneRepository;
import com.pibitaim.us.msjavagerenciadorusuarios.service.interfaces.TelefoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TelefoneServiceImpl implements TelefoneService {

    @Autowired
    private TelefoneRepository telefoneRepository;

    @Override
    public Page<Telefone> findAll(Pageable paginacao) {
        return telefoneRepository.findAll(paginacao);
    }
}
