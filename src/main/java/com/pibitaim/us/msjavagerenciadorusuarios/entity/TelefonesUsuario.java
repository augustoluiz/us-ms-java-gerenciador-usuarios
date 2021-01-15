package com.pibitaim.us.msjavagerenciadorusuarios.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@Entity(name = "TBUS006_TEL_USU")
public class TelefonesUsuario {

    @EmbeddedId
    private TelefonesUsuarioId telefonesUsuarioId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CPF_CNPJ")
    @MapsId("usuarioId")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COD_CAD_TEL")
    @MapsId("telefoneId")
    private Telefone telefone;

    @NotNull
    @Min(0)
    @Column(name = "NIV_PRIO")
    private Integer nivelPrioridade;

    @Column(name = "TEL_PRI")
    private Boolean telefonePrincipal;

    @Override
    public String toString() {
        return "TelefonesUsuario{" +
                "telefonesUsuarioId=" + telefonesUsuarioId +
                ", nivelPrioridade=" + nivelPrioridade +
                ", telefonePrincipal=" + telefonePrincipal +
                '}';
    }
}
