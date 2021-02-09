package com.pibitaim.us.msjavagerenciadorusuarios.service.interfaces;


import com.pibitaim.us.msjavagerenciadorusuarios.entity.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    List<Usuario> findAll();

    Optional<Usuario> findById(Long id);

}
