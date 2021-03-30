package com.pibitaim.us.msjavagerenciadorusuarios.controller.utils;

import com.pibitaim.us.msjavagerenciadorusuarios.service.interfaces.EnderecoService;
import com.pibitaim.us.msjavagerenciadorusuarios.service.interfaces.EnderecosUsuarioService;
import com.pibitaim.us.msjavagerenciadorusuarios.service.interfaces.UsuarioService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public class UsuarioUtils {

    public static boolean usuarioExiste(UsuarioService usuarioService, Long cpfCnpj){
        return usuarioService.findByCpfCnpj(cpfCnpj).isPresent();
    }

    public static Optional<UUID> findCodUsuarioByCpfCnpj(UsuarioService usuarioService, Long cpfCnpj){
        return usuarioService.findCodUsuarioByCpfCnpj(cpfCnpj);
    }

}
