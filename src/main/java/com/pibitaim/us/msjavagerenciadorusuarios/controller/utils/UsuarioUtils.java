package com.pibitaim.us.msjavagerenciadorusuarios.controller.utils;

import com.pibitaim.us.msjavagerenciadorusuarios.service.interfaces.UsuarioService;

import java.util.Optional;
import java.util.UUID;


public class UsuarioUtils {

    public static boolean usuarioExiste(UsuarioService usuarioService, Long cpfCnpj){
        return usuarioService.findByCpfCnpj(cpfCnpj).isPresent();
    }
    
    public static boolean emailCadastrado(UsuarioService usuarioService, String emailUsuario){
        return usuarioService.qtdEmailCadastrado(emailUsuario) > 0 ? true : false;
    }

    public static boolean emailCadastradoOutrosUsuarios(UsuarioService usuarioService, String emailUsuario, Long cpfCnpj){
        return usuarioService.qtdEmailCadastradoOutrosUsuarios(emailUsuario, cpfCnpj) > 0 ? true : false;
    }

    public static Optional<UUID> findCodUsuarioByCpfCnpj(UsuarioService usuarioService, Long cpfCnpj){
        return usuarioService.findCodUsuarioByCpfCnpj(cpfCnpj);
    }

}
