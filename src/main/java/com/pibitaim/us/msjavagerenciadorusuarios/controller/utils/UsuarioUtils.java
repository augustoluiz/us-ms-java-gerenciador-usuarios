package com.pibitaim.us.msjavagerenciadorusuarios.controller.utils;

import com.pibitaim.us.msjavagerenciadorusuarios.service.impl.UsuarioServiceImpl;
import com.pibitaim.us.msjavagerenciadorusuarios.service.interfaces.UsuarioService;


public class UsuarioUtils {

    public static boolean usuarioExiste(UsuarioService usuarioService, Long cpfCnpj){
        return usuarioService.findByCpfCnpj(cpfCnpj).isPresent();
    }

}
