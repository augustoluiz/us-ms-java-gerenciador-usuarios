package com.pibitaim.us.msjavagerenciadorusuarios.entity;

import com.pibitaim.us.msjavagerenciadorusuarios.entity.enums.EnumEstadoCivil;
import com.pibitaim.us.msjavagerenciadorusuarios.entity.enums.EnumSexoUsuario;
import com.pibitaim.us.msjavagerenciadorusuarios.entity.enums.EnumTipoPessoa;
import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity(name = "TBUS001_CAD_UNI_USU")
public class Usuario {

    @Id
    @NotNull
    @Digits(integer = 14, fraction = 0)
    @Column(name = "CPF_CNPJ")
    private Integer cpfCnpj;

    @NotNull
    @Column(columnDefinition = "VARCHAR(255)")
    private String nomeUsuario;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "CHAR(01)", name = "TIP_PES")
    private EnumTipoPessoa enumTipoPessoa;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "CHAR(01)", name = "SEX_USU")
    private EnumSexoUsuario enumSexoUsuario;

    @NotNull
    @Column(columnDefinition = "DATE", name = "DAT_NSC")
    private Date dataNascimento;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "CHAR(01)", name = "EST_CIV")
    private EnumEstadoCivil enumEstadoCivil;

    @NotNull
    @Column(name = "IND_MEM")
    private Boolean indicadorMembresia;

    @Column(columnDefinition = "DATE", name = "DAT_BAT")
    private Date dataBatismo;

    @NotNull
    @Column(name = "DAT_ULT_ATU")
    private Date dataUltimaAtualizacao;

    @NotNull
    @NotBlank
    @Column(columnDefinition = "VARCHAR(255)", name = "SEN_ACE_USU")
    private String senhaAcessoUsuario;

    public EnumSexoUsuario getEnumSexoUsuario() {
        return enumSexoUsuario;
    }

    public void setEnumSexoUsuario(EnumSexoUsuario enumSexoUsuario) {
        this.enumSexoUsuario = enumSexoUsuario;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public EnumEstadoCivil getEnumEstadoCivil() {
        return enumEstadoCivil;
    }

    public void setEnumEstadoCivil(EnumEstadoCivil enumEstadoCivil) {
        this.enumEstadoCivil = enumEstadoCivil;
    }

    public Boolean getIndicadorMembresia() {
        return indicadorMembresia;
    }

    public void setIndicadorMembresia(Boolean indicadorMembresia) {
        this.indicadorMembresia = indicadorMembresia;
    }

    public Date getDataBatismo() {
        return dataBatismo;
    }

    public void setDataBatismo(Date dataBatismo) {
        this.dataBatismo = dataBatismo;
    }

    public Date getDataUltimaAtualizacao() {
        return dataUltimaAtualizacao;
    }

    public void setDataUltimaAtualizacao(Date dataUltimaAtualizacao) {
        this.dataUltimaAtualizacao = dataUltimaAtualizacao;
    }

    public String getSenhaAcessoUsuario() {
        return senhaAcessoUsuario;
    }

    public void setSenhaAcessoUsuario(String senhaAcessoUsuario) {
        this.senhaAcessoUsuario = senhaAcessoUsuario;
    }

    public Usuario(@Digits(integer = 14, fraction = 0) Integer cpfCnpj, String nomeUsuario, EnumTipoPessoa enumTipoPessoa) {
        this.cpfCnpj = cpfCnpj;
        this.nomeUsuario = nomeUsuario;
        this.enumTipoPessoa = enumTipoPessoa;
    }

    public Integer getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(Integer cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public EnumTipoPessoa getEnumTipoPessoa() {
        return enumTipoPessoa;
    }

    public void setEnumTipoPessoa(EnumTipoPessoa enumTipoPessoa) {
        this.enumTipoPessoa = enumTipoPessoa;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "cpfCnpj=" + cpfCnpj +
                ", nomeUsuario='" + nomeUsuario + '\'' +
                ", enumTipoPessoa=" + enumTipoPessoa +
                ", enumSexoUsuario=" + enumSexoUsuario +
                ", dataNascimento=" + dataNascimento +
                ", enumEstadoCivil=" + enumEstadoCivil +
                ", indicadorMembresia=" + indicadorMembresia +
                ", dataBatismo=" + dataBatismo +
                ", dataUltimaAtualizacao=" + dataUltimaAtualizacao +
                ", senhaAcessoUsuario='" + senhaAcessoUsuario + '\'' +
                '}';
    }
}
