package com.pibitaim.us.msjavagerenciadorusuarios.entity.enums;

public enum EnumEstadoCivil {

    SOLTEIRO("S"), CASADO("C"), DIVORCIADO("D"), VIUVO("V");

    private String estadoCivil;

    EnumEstadoCivil(String estadoCivil){
        this.estadoCivil = estadoCivil.toUpperCase();
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }
}
