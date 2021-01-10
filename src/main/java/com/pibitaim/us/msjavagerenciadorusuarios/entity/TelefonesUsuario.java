package com.pibitaim.us.msjavagerenciadorusuarios.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity(name = "TBUS006_TEL_USU")
public class TelefonesUsuario {

    @EmbeddedId
    private TelefonesUsuarioId telefonesUsuarioId;

    @NotNull
    @Min(0)
    @Column(name = "NIV_PRIO")
    private Integer nivelPrioridade;

    @Column(name = "TEL_PRI")
    private Boolean telefonePrincipal;

    public TelefonesUsuario(TelefonesUsuarioId telefonesUsuarioId, @NotNull @Min(0) Integer nivelPrioridade, Boolean telefonePrincipal) {
        this.telefonesUsuarioId = telefonesUsuarioId;
        this.nivelPrioridade = nivelPrioridade;
        this.telefonePrincipal = telefonePrincipal;
    }

    public TelefonesUsuarioId getTelefonesUsuarioId() {
        return telefonesUsuarioId;
    }

    public void setTelefonesUsuarioId(TelefonesUsuarioId telefonesUsuarioId) {
        this.telefonesUsuarioId = telefonesUsuarioId;
    }

    public Integer getNivelPrioridade() {
        return nivelPrioridade;
    }

    public void setNivelPrioridade(Integer nivelPrioridade) {
        this.nivelPrioridade = nivelPrioridade;
    }

    public Boolean getTelefonePrincipal() {
        return telefonePrincipal;
    }

    public void setTelefonePrincipal(Boolean telefonePrincipal) {
        this.telefonePrincipal = telefonePrincipal;
    }

    @Override
    public String toString() {
        return "TelefonesUsuario{" +
                "telefonesUsuarioId=" + telefonesUsuarioId +
                ", nivelPrioridade=" + nivelPrioridade +
                ", telefonePrincipal=" + telefonePrincipal +
                '}';
    }
}
