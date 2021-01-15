package com.pibitaim.us.msjavagerenciadorusuarios.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class TelefonesUsuarioId implements Serializable {

    @Column(name = "CPF_CNPJ")
    private Long usuarioId;

    @Column(name = "COD_CAD_TEL")
    private Long telefoneId;
}
