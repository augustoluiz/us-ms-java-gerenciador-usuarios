package com.pibitaim.us.msjavagerenciadorusuarios.entity;

import com.pibitaim.us.msjavagerenciadorusuarios.entity.enums.EnumTipoEndereco;
import com.pibitaim.us.msjavagerenciadorusuarios.entity.enums.EnumUF;
import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name = "TBUS004_CAD_END_USU")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_CAD_END")
    private Long codigoCadastroEndereco;

    @NotNull
    @Column(name = "DAT_ULT_ATU")
    private Date dataUltimaAtualizacao;

    @NotNull
    @Min(0)
    @Digits(integer = 8, fraction = 0)
    @Column(name = "CEP_END")
    private Integer cepEndereco;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "CHAR(02)", name = "UF_END")
    private EnumUF uf;

    @NotNull
    @NotBlank
    @Column(columnDefinition = "VARCHAR(255)", name = "MUN_END")
    private String municipioEndereco;

    @NotNull
    @NotBlank
    @Column(columnDefinition = "VARCHAR(255)", name = "BAI_END")
    private String bairroEndereco;

    @NotNull
    @NotBlank
    @Column(columnDefinition = "VARCHAR(255)", name = "LOG_END")
    private String logradouroEndereco;

    @NotNull
    @NotBlank
    @Column(columnDefinition = "VARCHAR(255)", name = "COM_END")
    private String complementoEndereco;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "CHAR(01)", name = "TIP_END")
    private EnumTipoEndereco tipoEndereco;

    @OneToMany
    private List<EnderecosUsuario> enderecosUsuario = new ArrayList<>();

    public Endereco(Long codigoCadastroEndereco, Date dataUltimaAtualizacao, @Min(0) @Digits(integer = 8, fraction = 0) Integer cepEndereco, EnumUF uf, @NotBlank String municipioEndereco, @NotBlank String bairroEndereco, @NotBlank String logradouroEndereco, @NotBlank String complementoEndereco, EnumTipoEndereco tipoEndereco, List<EnderecosUsuario> enderecosUsuario) {
        this.codigoCadastroEndereco = codigoCadastroEndereco;
        this.dataUltimaAtualizacao = dataUltimaAtualizacao;
        this.cepEndereco = cepEndereco;
        this.uf = uf;
        this.municipioEndereco = municipioEndereco;
        this.bairroEndereco = bairroEndereco;
        this.logradouroEndereco = logradouroEndereco;
        this.complementoEndereco = complementoEndereco;
        this.tipoEndereco = tipoEndereco;
        this.enderecosUsuario = enderecosUsuario;
    }

    public Long getCodigoCadastroEndereco() {
        return codigoCadastroEndereco;
    }

    public void setCodigoCadastroEndereco(Long codigoCadastroEndereco) {
        this.codigoCadastroEndereco = codigoCadastroEndereco;
    }

    public Date getDataUltimaAtualizacao() {
        return dataUltimaAtualizacao;
    }

    public void setDataUltimaAtualizacao(Date dataUltimaAtualizacao) {
        this.dataUltimaAtualizacao = dataUltimaAtualizacao;
    }

    public Integer getCepEndereco() {
        return cepEndereco;
    }

    public void setCepEndereco(Integer cepEndereco) {
        this.cepEndereco = cepEndereco;
    }

    public EnumUF getUf() {
        return uf;
    }

    public void setUf(EnumUF uf) {
        this.uf = uf;
    }

    public String getMunicipioEndereco() {
        return municipioEndereco;
    }

    public void setMunicipioEndereco(String municipioEndereco) {
        this.municipioEndereco = municipioEndereco;
    }

    public String getBairroEndereco() {
        return bairroEndereco;
    }

    public void setBairroEndereco(String bairroEndereco) {
        this.bairroEndereco = bairroEndereco;
    }

    public String getLogradouroEndereco() {
        return logradouroEndereco;
    }

    public void setLogradouroEndereco(String logradouroEndereco) {
        this.logradouroEndereco = logradouroEndereco;
    }

    public String getComplementoEndereco() {
        return complementoEndereco;
    }

    public void setComplementoEndereco(String complementoEndereco) {
        this.complementoEndereco = complementoEndereco;
    }

    public EnumTipoEndereco getTipoEndereco() {
        return tipoEndereco;
    }

    public void setTipoEndereco(EnumTipoEndereco tipoEndereco) {
        this.tipoEndereco = tipoEndereco;
    }

    public List<EnderecosUsuario> getEnderecosUsuario() {
        return enderecosUsuario;
    }

    public void setEnderecosUsuario(List<EnderecosUsuario> enderecosUsuario) {
        this.enderecosUsuario = enderecosUsuario;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "codigoCadastroEndereco=" + codigoCadastroEndereco +
                ", dataUltimaAtualizacao=" + dataUltimaAtualizacao +
                ", cepEndereco=" + cepEndereco +
                ", uf=" + uf +
                ", municipioEndereco='" + municipioEndereco + '\'' +
                ", bairroEndereco='" + bairroEndereco + '\'' +
                ", logradouroEndereco='" + logradouroEndereco + '\'' +
                ", complementoEndereco='" + complementoEndereco + '\'' +
                ", tipoEndereco=" + tipoEndereco +
                ", enderecosUsuario=" + enderecosUsuario +
                '}';
    }
}
