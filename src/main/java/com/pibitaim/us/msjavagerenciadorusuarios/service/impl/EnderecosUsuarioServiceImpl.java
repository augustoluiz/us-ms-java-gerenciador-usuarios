package com.pibitaim.us.msjavagerenciadorusuarios.service.impl;

import com.pibitaim.us.msjavagerenciadorusuarios.entity.EnderecosUsuario;
import com.pibitaim.us.msjavagerenciadorusuarios.repository.EnderecosUsuarioRepository;
import com.pibitaim.us.msjavagerenciadorusuarios.service.interfaces.EnderecosUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EnderecosUsuarioServiceImpl implements EnderecosUsuarioService {

    @Autowired
    EnderecosUsuarioRepository enderecosUsuarioRepository;

    @Override
    public Optional<EnderecosUsuario> findEnderecoUsuarioById(Long cpfCnpj, Long codigoCadastroEndereco) {
        return enderecosUsuarioRepository.findEnderecoUsuarioById(cpfCnpj, codigoCadastroEndereco);
    }
}
