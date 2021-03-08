package com.pibitaim.us.msjavagerenciadorusuarios.data.form;

import com.pibitaim.us.msjavagerenciadorusuarios.entity.enums.EnumTipoEndereco;
import com.pibitaim.us.msjavagerenciadorusuarios.entity.enums.EnumUF;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@Getter
@Setter
public class EnderecoForm {

    @NotNull
    private Long codigoCadastroEndereco;

    @NotNull
    private Date dataUltimaAtualizacao;

    @NotNull
    private Integer cepEndereco;

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

    @NotNull
    @NotBlank
    private String complementoEndereco;

    @NotNull
    private EnumTipoEndereco tipoEndereco;

}
