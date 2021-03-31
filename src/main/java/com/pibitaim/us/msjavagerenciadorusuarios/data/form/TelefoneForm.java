package com.pibitaim.us.msjavagerenciadorusuarios.data.form;

import com.pibitaim.us.msjavagerenciadorusuarios.entity.enums.EnumTipoTelefone;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class TelefoneForm {

    @NotNull
    private Long cpfCnpjUsuario;

    @NotNull
    private boolean telefonePrincipal;

    @NotNull
    private Integer telefoneDDD;

    @NotNull
    private Integer telefoneNumero;

    @NotNull
    private EnumTipoTelefone tipoTelefone;

}
