package com.pibitaim.us.msjavagerenciadorusuarios.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@Entity(name = "TBUS005_END_USU")
public class EnderecosUsuario {

    @EmbeddedId
    private EnderecosUsuarioId enderecosUsuarioId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CPF_CNPJ")
    @MapsId("usuarioId")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COD_CAD_END")
    @MapsId("enderecoId")
    private Endereco endereco;

    @NotNull
    @Min(0)
    @Column(name = "NIV_PRIO")
    private Integer nivelPrioridade;

    @Column(name = "END_PRI")
    private Boolean enderecoPrincipal;

    @Override
    public String toString() {
        return "EnderecosUsuario{" +
                "enderecosUsuarioId=" + enderecosUsuarioId +
                ", nivelPrioridade=" + nivelPrioridade +
                ", enderecoPrincipal=" + enderecoPrincipal +
                '}';
    }
}
