package com.pibitaim.us.msjavagerenciadorusuarios.data.form;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class TelefonesUsuarioForm {

    @NotNull
    private TelefoneForm telefone;

    @NotNull
    private Integer nivelPrioridade;

    @NotNull
    private Boolean telefonePrincipal;

}
