package com.pibitaim.us.msjavagerenciadorusuarios.data.dto;

import com.pibitaim.us.msjavagerenciadorusuarios.entity.EnderecosUsuario;
import com.pibitaim.us.msjavagerenciadorusuarios.entity.TelefonesUsuario;
import com.pibitaim.us.msjavagerenciadorusuarios.entity.enums.EnumEstadoCivil;
import com.pibitaim.us.msjavagerenciadorusuarios.entity.enums.EnumSexoUsuario;
import com.pibitaim.us.msjavagerenciadorusuarios.entity.enums.EnumTipoPessoa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Getter
@Setter
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
    private List<EmailDTO> emailsUsuario;
    private List<EnderecosUsuarioDTO> enderecosUsuario;
    private List<TelefonesUsuarioDTO> telefonesUsuario;

}
