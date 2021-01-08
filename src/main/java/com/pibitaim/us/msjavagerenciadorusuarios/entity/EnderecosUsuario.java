package com.pibitaim.us.msjavagerenciadorusuarios.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity(name = "TBUS005_END_USU")
public class EnderecosUsuario {

    @EmbeddedId
    private EnderecosUsuarioId enderecosUsuarioId;

    @Min(0)
    @Column(name = "NIV_PRIO")
    private Integer nivelPrioridade;

    @Column(name = "END_PRI")
    private Boolean enderecoPrincipal;

    public EnderecosUsuario(EnderecosUsuarioId enderecosUsuarioId, @Min(0) Integer nivelPrioridade, Boolean enderecoPrincipal) {
        this.enderecosUsuarioId = enderecosUsuarioId;
        this.nivelPrioridade = nivelPrioridade;
        this.enderecoPrincipal = enderecoPrincipal;
    }

    public EnderecosUsuarioId getEnderecosUsuarioId() {
        return enderecosUsuarioId;
    }

    public void setEnderecosUsuarioId(EnderecosUsuarioId enderecosUsuarioId) {
        this.enderecosUsuarioId = enderecosUsuarioId;
    }

    public Integer getNivelPrioridade() {
        return nivelPrioridade;
    }

    public void setNivelPrioridade(Integer nivelPrioridade) {
        this.nivelPrioridade = nivelPrioridade;
    }

    public Boolean getEnderecoPrincipal() {
        return enderecoPrincipal;
    }

    public void setEnderecoPrincipal(Boolean enderecoPrincipal) {
        this.enderecoPrincipal = enderecoPrincipal;
    }

    @Override
    public String toString() {
        return "EnderecosUsuario{" +
                "enderecosUsuarioId=" + enderecosUsuarioId +
                ", nivelPrioridade=" + nivelPrioridade +
                ", enderecoPrincipal=" + enderecoPrincipal +
                '}';
    }
}
