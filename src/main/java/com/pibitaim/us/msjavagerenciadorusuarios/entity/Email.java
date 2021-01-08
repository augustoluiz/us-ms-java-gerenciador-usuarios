package com.pibitaim.us.msjavagerenciadorusuarios.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity(name = "TBUS002_CAD_CTO_MAIL_USU")
public class Email {

    @NotBlank
    @NotNull
    @Id
    @Column(name = "MAIL_USU")
    private String emailUsuario;

    @ManyToOne
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

    public Email(@NotBlank String emailUsuario, Usuario usuario, Date dataUltimaAtualizacao, Boolean emailLogin, @Min(0) Integer nivelPrivilegio) {
        this.emailUsuario = emailUsuario;
        this.usuario = usuario;
        this.dataUltimaAtualizacao = dataUltimaAtualizacao;
        this.emailLogin = emailLogin;
        this.nivelPrivilegio = nivelPrivilegio;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getDataUltimaAtualizacao() {
        return dataUltimaAtualizacao;
    }

    public void setDataUltimaAtualizacao(Date dataUltimaAtualizacao) {
        this.dataUltimaAtualizacao = dataUltimaAtualizacao;
    }

    public Boolean getEmailLogin() {
        return emailLogin;
    }

    public void setEmailLogin(Boolean emailLogin) {
        this.emailLogin = emailLogin;
    }

    public Integer getNivelPrivilegio() {
        return nivelPrivilegio;
    }

    public void setNivelPrivilegio(Integer nivelPrivilegio) {
        this.nivelPrivilegio = nivelPrivilegio;
    }
}
