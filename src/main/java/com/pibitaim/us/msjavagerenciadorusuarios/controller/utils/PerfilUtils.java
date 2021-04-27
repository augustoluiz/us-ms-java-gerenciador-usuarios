package com.pibitaim.us.msjavagerenciadorusuarios.controller.utils;

import com.pibitaim.us.msjavagerenciadorusuarios.entity.enums.EnumPapel;
import com.pibitaim.us.msjavagerenciadorusuarios.entity.enums.EnumPermissao;
import com.pibitaim.us.msjavagerenciadorusuarios.service.interfaces.PerfilService;

public class PerfilUtils {

    public static boolean perfilExiste(PerfilService perfilService, Long id){
        return perfilService.existsById(id);
    }

    public static boolean perfilExiste(PerfilService perfilService, EnumPapel papel, EnumPermissao permissao){
        return perfilService.existsByPapelPermissao(papel, permissao);
    }

}
