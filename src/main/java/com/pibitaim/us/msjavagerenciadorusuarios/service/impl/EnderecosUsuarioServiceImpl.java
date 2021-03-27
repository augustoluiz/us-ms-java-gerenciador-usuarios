package com.pibitaim.us.msjavagerenciadorusuarios.service.impl;

import com.pibitaim.us.msjavagerenciadorusuarios.entity.EnderecosUsuario;
import com.pibitaim.us.msjavagerenciadorusuarios.repository.EnderecosUsuarioRepository;
import com.pibitaim.us.msjavagerenciadorusuarios.service.interfaces.EnderecosUsuarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EnderecosUsuarioServiceImpl implements EnderecosUsuarioService {

    @Autowired
    EnderecosUsuarioRepository enderecosUsuarioRepository;

    @Override
    public Integer qtdEnderecosCodUsuario(String codUsuario) {
        return enderecosUsuarioRepository.qtdEnderecosPorCodUsuario(codUsuario);
    }

    @Override
    public Integer getUltimoNivelPrioridade(String codUsuario) {
        return enderecosUsuarioRepository.getUltimoNivelPrioridade(codUsuario);
    }

    @Override
    public Boolean existeEnderecosCadastradosParaCodUsuario(String codUsuario) {
        return enderecosUsuarioRepository.existeEnderecosCadastradosParaCodigoUsuario(codUsuario).isPresent();
    }

    @Override
    public void atualizaEnderecosPrincipais(String codUsuario) {
        enderecosUsuarioRepository.atualizaEnderecosPrincipais(codUsuario);
    }

    @Override
    public EnderecosUsuario save(EnderecosUsuario enderecosUsuario) {
        return enderecosUsuarioRepository.save(enderecosUsuario);
    }
}
