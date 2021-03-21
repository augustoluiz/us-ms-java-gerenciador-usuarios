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

    @Override
    public Integer qtdEnderecosPorCpfCnpj(Long cpfCnpjUsuario) {
        return enderecosUsuarioRepository.qtdEnderecosPorCpfCnpj(cpfCnpjUsuario);
    }

    @Override
    public Integer getUltimoNivelPrioridade(Long cpfCnpjUsuario) {
        return enderecosUsuarioRepository.getUltimoNivelPrioridade(cpfCnpjUsuario);
    }

    @Override
    public Boolean existeEnderecosCadastradosParaCpfCnpj(Long cpfCnpjUsuario) {
        return enderecosUsuarioRepository.existeEnderecosCadastradosParaCpfCnpj(cpfCnpjUsuario).isPresent();
    }

    @Override
    public void atualizaEnderecosPrincipais(Long cpfCnpjUsuario) {
        enderecosUsuarioRepository.atualizaEnderecosPrincipais(cpfCnpjUsuario);
    }

    @Override
    public EnderecosUsuario save(EnderecosUsuario enderecosUsuario) {
        return enderecosUsuarioRepository.save(enderecosUsuario);
    }
}
