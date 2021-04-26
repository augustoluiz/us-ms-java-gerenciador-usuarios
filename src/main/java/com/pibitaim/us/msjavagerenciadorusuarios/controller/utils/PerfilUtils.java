package com.pibitaim.us.msjavagerenciadorusuarios.controller.utils;

import com.pibitaim.us.msjavagerenciadorusuarios.service.interfaces.PerfilService;

public class PerfilUtils {

    public static boolean perfilExiste(PerfilService perfilService, Long id){
        return perfilService.findById(id).isPresent();
    }

}
