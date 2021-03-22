package com.pibitaim.us.msjavagerenciadorusuarios.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.UUID;

@Embeddable
public class TelefonesUsuarioId implements Serializable {

    @Column(name = "COD_IDE_USU")
    private UUID usuarioId;

    @Column(name = "COD_CAD_TEL")
    private Long telefoneId;
}
