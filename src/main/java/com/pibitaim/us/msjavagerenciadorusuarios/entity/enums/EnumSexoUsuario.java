package com.pibitaim.us.msjavagerenciadorusuarios.entity.enums;

public enum EnumSexoUsuario {

    MASCULINO("M"), FEMININO("F");

    private String sexoUsuario;

    EnumSexoUsuario(String sexoUsuario){
        this.sexoUsuario = sexoUsuario.toUpperCase();
    }

    public String getSexoUsuario() {
        return sexoUsuario;
    }
}
