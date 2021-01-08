package com.pibitaim.us.msjavagerenciadorusuarios.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class EnderecosUsuarioId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "CPF_CNPJ")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "COD_CAD_END")
    private Endereco endereco;

}
