package com.pibitaim.us.msjavagerenciadorusuarios.controller.utils;

import com.pibitaim.us.msjavagerenciadorusuarios.entity.EnderecosUsuario;
import com.pibitaim.us.msjavagerenciadorusuarios.service.interfaces.EnderecoService;
import com.pibitaim.us.msjavagerenciadorusuarios.service.interfaces.EnderecosUsuarioService;

public class EnderecoUtils {

    public static boolean enderecoExiste(EnderecoService enderecoService, Long id){
        return enderecoService.findById(id).isPresent();
    }

    public static Integer qtdEnderecosPorCpfCnpj(EnderecosUsuarioService enderecosUsuarioService, Long cpfCnpjUsuario){
        return enderecosUsuarioService.qtdEnderecosPorCpfCnpj(cpfCnpjUsuario);
    }

    public static Integer getUltimoNivelPrioridade(EnderecosUsuarioService enderecosUsuarioService, Long cpfCnpjUsuario){
        return enderecosUsuarioService.getUltimoNivelPrioridade(cpfCnpjUsuario);
    }

    public static boolean existeEnderecosCadastradosParaCpfCnpj(EnderecosUsuarioService enderecosUsuarioService, Long cpfCnpjUsuario){
        return enderecosUsuarioService.existeEnderecosCadastradosParaCpfCnpj(cpfCnpjUsuario);
    }

}
