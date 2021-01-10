package com.pibitaim.us.msjavagerenciadorusuarios.entity;

import com.pibitaim.us.msjavagerenciadorusuarios.entity.enums.EnumTipoTelefone;
import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name = "TBUS003_CAD_TEL_USU")
public class Telefone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_CAD_TEL")
    private Long codigoCadastroTelefone;

    @NotNull
    @Column(name = "DAT_ULT_ATU")
    private Date dataUltimaAtualizacao;

    @Min(0)
    @Column(name = "TEL_DDD", length = 2)
    private Integer telefoneDDD;

    @Min(0)
    @Column(name = "TEL_NUM", length = 9)
    private Integer telefoneNumero;

    @Column(name = "TIP_TEL", columnDefinition = "CHAR(01)")
    private EnumTipoTelefone tipoTelefone;

    @OneToMany
    private List<TelefonesUsuario> telefonesUsuarios = new ArrayList<>();

    public Telefone(Long codigoCadastroTelefone, Date dataUltimaAtualizacao, @Min(0) Integer telefoneDDD, @Min(0) Integer telefoneNumero, EnumTipoTelefone tipoTelefone, List<TelefonesUsuario> telefonesUsuarios) {
        this.codigoCadastroTelefone = codigoCadastroTelefone;
        this.dataUltimaAtualizacao = dataUltimaAtualizacao;
        this.telefoneDDD = telefoneDDD;
        this.telefoneNumero = telefoneNumero;
        this.tipoTelefone = tipoTelefone;
        this.telefonesUsuarios = telefonesUsuarios;
    }

    public Long getCodigoCadastroTelefone() {
        return codigoCadastroTelefone;
    }

    public void setCodigoCadastroTelefone(Long codigoCadastroTelefone) {
        this.codigoCadastroTelefone = codigoCadastroTelefone;
    }

    public Date getDataUltimaAtualizacao() {
        return dataUltimaAtualizacao;
    }

    public void setDataUltimaAtualizacao(Date dataUltimaAtualizacao) {
        this.dataUltimaAtualizacao = dataUltimaAtualizacao;
    }

    public Integer getTelefoneDDD() {
        return telefoneDDD;
    }

    public void setTelefoneDDD(Integer telefoneDDD) {
        this.telefoneDDD = telefoneDDD;
    }

    public Integer getTelefoneNumero() {
        return telefoneNumero;
    }

    public void setTelefoneNumero(Integer telefoneNumero) {
        this.telefoneNumero = telefoneNumero;
    }

    public EnumTipoTelefone getTipoTelefone() {
        return tipoTelefone;
    }

    public void setTipoTelefone(EnumTipoTelefone tipoTelefone) {
        this.tipoTelefone = tipoTelefone;
    }

    public List<TelefonesUsuario> getTelefonesUsuarios() {
        return telefonesUsuarios;
    }

    public void setTelefonesUsuarios(List<TelefonesUsuario> telefonesUsuarios) {
        this.telefonesUsuarios = telefonesUsuarios;
    }

    @Override
    public String toString() {
        return "Telefone{" +
                "codigoCadastroTelefone=" + codigoCadastroTelefone +
                ", dataUltimaAtualizacao=" + dataUltimaAtualizacao +
                ", telefoneDDD=" + telefoneDDD +
                ", telefoneNumero=" + telefoneNumero +
                ", tipoTelefone=" + tipoTelefone +
                ", telefonesUsuarios=" + telefonesUsuarios.toString() +
                '}';
    }
}
