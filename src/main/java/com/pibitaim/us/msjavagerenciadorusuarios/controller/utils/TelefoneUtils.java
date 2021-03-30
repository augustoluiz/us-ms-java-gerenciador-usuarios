package com.pibitaim.us.msjavagerenciadorusuarios.controller.utils;

import com.pibitaim.us.msjavagerenciadorusuarios.service.interfaces.TelefoneService;

public class TelefoneUtils {

    public static boolean telefoneExiste(TelefoneService telefoneService, Long telefoneId){
        return telefoneService.findById(telefoneId).isPresent();
    }

}
