package com.pibitaim.us.msjavagerenciadorusuarios.data.dto;

import com.pibitaim.us.msjavagerenciadorusuarios.entity.EnderecosUsuarioId;
import com.pibitaim.us.msjavagerenciadorusuarios.entity.enums.EnumTipoEndereco;
import com.pibitaim.us.msjavagerenciadorusuarios.entity.enums.EnumUF;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
public class EnderecosUsuarioDTO {

    private Long codigoCadastroEndereco;
    private Integer nivelPrioridade;
    private Boolean enderecoPrincipal;
    private Date dataUltimaAtualizacao;
    private Integer cepEndereco;
    private EnumUF uf;
    private String municipioEndereco;
    private String bairroEndereco;
    private String logradouroEndereco;
    private String complementoEndereco;
    private EnumTipoEndereco tipoEndereco;

}
