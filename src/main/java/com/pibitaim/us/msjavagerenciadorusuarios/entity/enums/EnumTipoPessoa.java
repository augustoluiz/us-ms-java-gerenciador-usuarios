package com.pibitaim.us.msjavagerenciadorusuarios.entity.enums;

public enum EnumTipoPessoa {

    PF("F"), PJ("J");

    private final String tipoPessoa;

    EnumTipoPessoa(String tipoPessoa) {
        this.tipoPessoa = tipoPessoa.toUpperCase();
    }

    public String getTipoPessoa(){
        return this.tipoPessoa;
    }

}
