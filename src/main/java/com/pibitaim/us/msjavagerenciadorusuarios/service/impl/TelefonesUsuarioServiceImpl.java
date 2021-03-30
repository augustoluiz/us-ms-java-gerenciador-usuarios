package com.pibitaim.us.msjavagerenciadorusuarios.service.impl;

import com.pibitaim.us.msjavagerenciadorusuarios.entity.TelefonesUsuario;
import com.pibitaim.us.msjavagerenciadorusuarios.repository.TelefonesUsuarioRepository;
import com.pibitaim.us.msjavagerenciadorusuarios.service.interfaces.TelefonesUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TelefonesUsuarioServiceImpl implements TelefonesUsuarioService {

    @Autowired
    private TelefonesUsuarioRepository telefonesUsuarioRepository;

    @Override
    public boolean existeTelefonesCadastradosParaCodUsuario(String codUsuario) {
        return telefonesUsuarioRepository.existeTelefonesCadastradosParaCodUsuario(codUsuario).isPresent();
    }

    @Override
    public void atualizaTelefonesPrincipais(String codUsuario) {
        telefonesUsuarioRepository.atualizaTelefonesPrincipais(codUsuario);
    }

    @Override
    public Integer qtdTelefonesCodUsuario(String codUsuario) {
        return telefonesUsuarioRepository.qtdTelefonesPorCodUsuario(codUsuario);
    }

    @Override
    public Integer getUltimoNivelPrioridade(String codUsuario) {
        return telefonesUsuarioRepository.getUltimoNivelPrioridade(codUsuario);
    }

    @Override
    public TelefonesUsuario save(TelefonesUsuario telefonesUsuario) {
        return telefonesUsuarioRepository.save(telefonesUsuario);
    }
}
