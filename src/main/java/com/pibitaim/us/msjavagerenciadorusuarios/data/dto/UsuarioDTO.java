package com.pibitaim.us.msjavagerenciadorusuarios.data.dto;

import com.pibitaim.us.msjavagerenciadorusuarios.entity.EnderecosUsuario;
import com.pibitaim.us.msjavagerenciadorusuarios.entity.TelefonesUsuario;
import com.pibitaim.us.msjavagerenciadorusuarios.entity.enums.EnumEstadoCivil;
import com.pibitaim.us.msjavagerenciadorusuarios.entity.enums.EnumSexoUsuario;
import com.pibitaim.us.msjavagerenciadorusuarios.entity.enums.EnumTipoPessoa;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class UsuarioDTO {

    private Long cpfCnpj;
    private String nomeUsuario;
    private EnumTipoPessoa enumTipoPessoa;
    private EnumSexoUsuario enumSexoUsuario;
    private Date dataNascimento;
    private EnumEstadoCivil enumEstadoCivil;
    private Boolean indicadorMembresia;
    private Date dataBatismo;
    private Date dataUltimaAtualizacao;
    private List<EnderecosUsuarioDTO> enderecosUsuario = new ArrayList<>();
    // List<TelefonesUsuarioDTO> telefonesUsuario = new ArrayList<>();

}
