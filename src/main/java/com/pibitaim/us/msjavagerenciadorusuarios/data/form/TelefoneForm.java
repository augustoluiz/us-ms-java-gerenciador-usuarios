package com.pibitaim.us.msjavagerenciadorusuarios.data.form;

import com.pibitaim.us.msjavagerenciadorusuarios.entity.enums.EnumTipoTelefone;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
@Getter
@Setter
public class TelefoneForm {

    @NotNull
    private Long codigoCadastroTelefone;

    @NotNull
    private Date dataUltimaAtualizacao;

    @NotNull
    private Integer telefoneDDD;

    @NotNull
    private Integer telefoneNumero;

    @NotNull
    private EnumTipoTelefone tipoTelefone;

}
