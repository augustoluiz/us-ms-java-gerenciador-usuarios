package com.pibitaim.us.msjavagerenciadorusuarios.service.interfaces;

import com.pibitaim.us.msjavagerenciadorusuarios.entity.Telefone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TelefoneService {

    Page<Telefone> findAll(Pageable paginacao);

}
