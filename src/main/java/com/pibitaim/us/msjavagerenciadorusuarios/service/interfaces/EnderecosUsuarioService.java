package com.pibitaim.us.msjavagerenciadorusuarios.service.interfaces;

import com.pibitaim.us.msjavagerenciadorusuarios.entity.EnderecosUsuario;

public interface EnderecosUsuarioService {

    Integer qtdEnderecosCodUsuario(String codUsuario);

    Integer getUltimoNivelPrioridade(String codUsuario);

    Boolean existeEnderecosCadastradosParaCodUsuario(String codUsuario);

    void atualizaEnderecosPrincipais(String codUsuario);

    EnderecosUsuario save(EnderecosUsuario enderecosUsuario);
}
