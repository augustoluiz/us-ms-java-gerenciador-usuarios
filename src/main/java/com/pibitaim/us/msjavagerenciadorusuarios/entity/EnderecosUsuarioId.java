package com.pibitaim.us.msjavagerenciadorusuarios.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Getter
@Setter
@Embeddable
public class EnderecosUsuarioId implements Serializable {

    @Column(name = "CPF_CNPJ")
    private Long usuarioId;

    @Column(name = "COD_CAD_END")
    private Long enderecoId;

}
