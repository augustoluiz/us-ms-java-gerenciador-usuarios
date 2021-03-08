package com.pibitaim.us.msjavagerenciadorusuarios.service.interfaces;

import com.pibitaim.us.msjavagerenciadorusuarios.entity.EnderecosUsuario;

import java.util.Optional;

public interface EnderecosUsuarioService {

    Optional<EnderecosUsuario> findEnderecoUsuarioById(Long cpfCnpj, Long codigoCadastroEndereco);

}
