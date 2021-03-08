package com.pibitaim.us.msjavagerenciadorusuarios.data.form;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Data
@Getter
@Setter
public class EmailForm {

    @NotNull
    @NotBlank
    private String email;

    @NotNull
    private boolean emailLogin;

    @NotNull
    private Integer nivelPrivilegio;

}
