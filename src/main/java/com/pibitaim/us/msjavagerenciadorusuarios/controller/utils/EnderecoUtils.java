package com.pibitaim.us.msjavagerenciadorusuarios.controller.utils;

import com.pibitaim.us.msjavagerenciadorusuarios.service.interfaces.EnderecoService;

public class EnderecoUtils {

    public static boolean enderecoExiste(EnderecoService enderecoService, Long id){
        return enderecoService.findById(id).isPresent();
    }

}
