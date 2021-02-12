package com.pibitaim.us.msjavagerenciadorusuarios.service.interfaces;


import com.pibitaim.us.msjavagerenciadorusuarios.entity.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Optional;

public interface UsuarioService {

    Page<Usuario> findAll(Pageable paginacao);

    Optional<Usuario> findById(Long id);

}
