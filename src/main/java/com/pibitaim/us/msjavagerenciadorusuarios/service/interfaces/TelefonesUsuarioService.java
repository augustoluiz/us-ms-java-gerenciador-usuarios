package com.pibitaim.us.msjavagerenciadorusuarios.service.interfaces;

import com.pibitaim.us.msjavagerenciadorusuarios.entity.TelefonesUsuario;

public interface TelefonesUsuarioService {

    boolean existeTelefonesCadastradosParaCodUsuario(String codUsuario);

    void atualizaTelefonesPrincipais(String codUsuario);

    Integer qtdTelefonesCodUsuario(String codUsuario);

    Integer getUltimoNivelPrioridade(String codUsuario);

    TelefonesUsuario save(TelefonesUsuario telefonesUsuario);
}
