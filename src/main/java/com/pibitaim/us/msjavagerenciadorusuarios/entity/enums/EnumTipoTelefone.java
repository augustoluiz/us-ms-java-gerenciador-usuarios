package com.pibitaim.us.msjavagerenciadorusuarios.entity.enums;

public enum EnumTipoTelefone {

    TELEFONE_FIXO("F"), TELEFONE_CELULAR("C");

    private String tipoTelefone;

    EnumTipoTelefone(String tipoTelefone) {
        this.tipoTelefone = tipoTelefone.toUpperCase();
    }

    public String getTipoTelefone() {
        return tipoTelefone;
    }
}
