package com.pibitaim.us.msjavagerenciadorusuarios.service.interfaces;

import com.pibitaim.us.msjavagerenciadorusuarios.entity.EnderecosUsuario;

import java.util.Optional;

public interface EnderecosUsuarioService {

    Optional<EnderecosUsuario> findEnderecoUsuarioById(Long cpfCnpj, Long codigoCadastroEndereco);

    Integer qtdEnderecosPorCpfCnpj(Long cpfCnpjUsuario);

    Integer getUltimoNivelPrioridade(Long cpfCnpjUsuario);

    Boolean existeEnderecosCadastradosParaCpfCnpj(Long cpfCnpjUsuario);

    void atualizaEnderecosPrincipais(Long cpfCnpjUsuario);

    EnderecosUsuario save(EnderecosUsuario enderecosUsuario);
}
