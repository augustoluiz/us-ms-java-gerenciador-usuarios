package com.pibitaim.us.msjavagerenciadorusuarios.controller.utils;

import com.pibitaim.us.msjavagerenciadorusuarios.service.interfaces.TelefoneService;
import com.pibitaim.us.msjavagerenciadorusuarios.service.interfaces.TelefonesUsuarioService;

public class TelefoneUtils {

    public static boolean telefoneExiste(TelefoneService telefoneService, Long telefoneId){
        return telefoneService.findById(telefoneId).isPresent();
    }

    public static boolean existeTelefonesCadastradosParaCodUsuario(TelefonesUsuarioService telefonesUsuarioService, String codUsuario){
        return telefonesUsuarioService.existeTelefonesCadastradosParaCodUsuario(codUsuario);
    }

    public static Integer qtdTelefonesCodUsuario(TelefonesUsuarioService telefonesUsuarioService, String codUsuario){
        return telefonesUsuarioService.qtdTelefonesCodUsuario(codUsuario);
    }

    public static Integer getUltimoNivelPrioridade(TelefonesUsuarioService telefonesUsuarioService, String codUsuario){
        return telefonesUsuarioService.getUltimoNivelPrioridade(codUsuario);
    }

}
