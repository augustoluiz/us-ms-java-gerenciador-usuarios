package com.pibitaim.us.msjavagerenciadorusuarios.data.form;

import com.pibitaim.us.msjavagerenciadorusuarios.entity.enums.EnumTipoEndereco;
import com.pibitaim.us.msjavagerenciadorusuarios.entity.enums.EnumUF;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Getter
@Setter
public class EnderecoForm {

    @NotNull
    private Long cpfCnpjUsuario;

    @NotNull
    private boolean enderecoPrincipal;

    @Size(max = 8)
    @NotNull
    @NotBlank
    private String cepEndereco;

    @NotNull
    private EnumUF uf;

    @NotNull
    @NotBlank
    private String municipioEndereco;

    @NotNull
    @NotBlank
    private String bairroEndereco;

    @NotNull
    @NotBlank
    private String logradouroEndereco;

    private String complementoEndereco;

    @NotNull
    private EnumTipoEndereco tipoEndereco;

}
