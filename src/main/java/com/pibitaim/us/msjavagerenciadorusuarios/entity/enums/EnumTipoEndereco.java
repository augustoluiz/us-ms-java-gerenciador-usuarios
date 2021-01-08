package com.pibitaim.us.msjavagerenciadorusuarios.entity.enums;

public enum EnumTipoEndereco {

    CASA("C"), APARTAMENTO("A");

    private String tipoEndereco;

    EnumTipoEndereco(String tipoEndereco) {
        this.tipoEndereco = tipoEndereco.toUpperCase();
    }

    public String getTipoEndereco() {
        return tipoEndereco;
    }
}
