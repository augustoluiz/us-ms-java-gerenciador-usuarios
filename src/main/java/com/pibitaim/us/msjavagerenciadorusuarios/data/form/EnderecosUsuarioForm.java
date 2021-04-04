package com.pibitaim.us.msjavagerenciadorusuarios.data.form;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Data
@Getter
@Setter
public class EnderecosUsuarioForm {

    @NotNull
    private Long codigoCadastroEndereco;

    @NotNull
    private Long cpfCnpjUsuario;

    @NotNull
    private Integer nivelPrioridade;

    @NotNull
    private Boolean enderecoPrincipal;

}
