package com.pibitaim.us.msjavagerenciadorusuarios.data.form;

import com.pibitaim.us.msjavagerenciadorusuarios.entity.enums.EnumEstadoCivil;
import com.pibitaim.us.msjavagerenciadorusuarios.entity.enums.EnumSexoUsuario;
import com.pibitaim.us.msjavagerenciadorusuarios.entity.enums.EnumTipoPessoa;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@Getter
@Setter
public class UsuarioForm {

    @NotNull
    private Long cpfCnpj;

    @NotNull
    @NotBlank
    private String nomeUsuario;

    @NotNull
    private EnumTipoPessoa enumTipoPessoa;

    @NotNull
    private EnumSexoUsuario enumSexoUsuario;

    @NotNull
    private Date dataNascimento;

    @NotNull
    private EnumEstadoCivil enumEstadoCivil;

    @NotNull
    private Boolean indicadorMembresia;

    private Date dataBatismo;

}
