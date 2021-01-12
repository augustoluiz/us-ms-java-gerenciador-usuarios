package com.pibitaim.us.msjavagerenciadorusuarios.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Data
@Getter
@Setter
@Embeddable
public class EnderecosUsuarioId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "CPF_CNPJ")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "COD_CAD_END")
    private Endereco endereco;

}
