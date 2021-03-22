package com.pibitaim.us.msjavagerenciadorusuarios.entity;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@Entity(name = "TBUS002_CAD_CTO_MAIL_USU")
public class Email {

    @NotBlank
    @NotNull
    @Id
    @Column(name = "MAIL_USU")
    private String emailUsuario;

    @ManyToOne
    @JoinColumn(name = "COD_IDE_USU")
    private Usuario usuario;

    @NotNull
    @Column(name = "DAT_ULT_ATU")
    private Date dataUltimaAtualizacao;

    @NotNull
    @Column(name = "MAIL_LOG")
    private Boolean emailLogin;

    @NotNull
    @Min(0)
    @Column(name = "NIV_PRI")
    private Integer nivelPrivilegio;

    @Override
    public String toString() {
        return "Email{" +
                "emailUsuario='" + emailUsuario + '\'' +
                ", usuario=" + usuario +
                ", dataUltimaAtualizacao=" + dataUltimaAtualizacao +
                ", emailLogin=" + emailLogin +
                ", nivelPrivilegio=" + nivelPrivilegio +
                '}';
    }
}
