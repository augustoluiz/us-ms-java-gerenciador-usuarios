package com.pibitaim.us.msjavagerenciadorusuarios.entity;

import com.pibitaim.us.msjavagerenciadorusuarios.entity.enums.EnumEstadoCivil;
import com.pibitaim.us.msjavagerenciadorusuarios.entity.enums.EnumSexoUsuario;
import com.pibitaim.us.msjavagerenciadorusuarios.entity.enums.EnumTipoPessoa;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Getter
@Setter
@Entity(name = "TBUS001_CAD_UNI_USU")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type="uuid-char")
    @Column(name = "COD_IDE_USU")
    private UUID codUsuario;

    @NotNull
    @Column(columnDefinition = "BIGINT(14)", name = "CPF_CNPJ")
    private Long cpfCnpj;

    @NotNull
    @Column(columnDefinition = "VARCHAR(255)", name = "NOM_USU")
    private String nomeUsuario;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "CHAR(01)", name = "TIP_PES")
    private EnumTipoPessoa enumTipoPessoa;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "CHAR(01)", name = "SEX_USU")
    private EnumSexoUsuario enumSexoUsuario;

    @NotNull
    @Column(columnDefinition = "DATE", name = "DAT_NSC")
    private LocalDate dataNascimento;


    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "CHAR(01)", name = "EST_CIV")
    private EnumEstadoCivil enumEstadoCivil;

    @NotNull
    @Column(name = "IND_MEM")
    private Boolean indicadorMembresia;

    @Column(columnDefinition = "DATE", name = "DAT_BAT")
    private LocalDate dataBatismo;

    @NotNull
    @Column(name = "DAT_ULT_ATU")
    private Date dataUltimaAtualizacao;

    @NotNull
    @NotBlank
    @Column(name = "EMAIL_USU")
    private String emailUsuario;

    @NotNull
    @NotBlank
    @Column(columnDefinition = "VARCHAR(255)", name = "SEN_ACE_USU")
    private String senhaAcessoUsuario;

    @OneToMany(
            mappedBy = "usuario",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<EnderecosUsuario> enderecosUsuario;

    @OneToMany(
            mappedBy = "usuario",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<TelefonesUsuario> telefonesUsuario;

    public void setEnderecosUsuario(List<EnderecosUsuario> enderecosUsuario) {
        this.enderecosUsuario = enderecosUsuario;
    }

    public void setTelefonesUsuario(List<TelefonesUsuario> telefonesUsuario) {
        this.telefonesUsuario = telefonesUsuario;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "codUsuario=" + codUsuario +
                ", cpfCnpj=" + cpfCnpj +
                ", nomeUsuario='" + nomeUsuario + '\'' +
                ", enumTipoPessoa=" + enumTipoPessoa +
                ", enumSexoUsuario=" + enumSexoUsuario +
                ", dataNascimento=" + dataNascimento +
                ", enumEstadoCivil=" + enumEstadoCivil +
                ", indicadorMembresia=" + indicadorMembresia +
                ", dataBatismo=" + dataBatismo +
                ", dataUltimaAtualizacao=" + dataUltimaAtualizacao +
                ", emailUsuario='" + emailUsuario + '\'' +
                ", senhaAcessoUsuario='" + senhaAcessoUsuario + '\'' +
                ", enderecosUsuario=" + enderecosUsuario +
                ", telefonesUsuario=" + telefonesUsuario +
                '}';
    }
}
