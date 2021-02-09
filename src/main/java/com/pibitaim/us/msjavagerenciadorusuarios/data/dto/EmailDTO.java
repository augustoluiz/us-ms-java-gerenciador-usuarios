package com.pibitaim.us.msjavagerenciadorusuarios.data.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class EmailDTO {

    private String email;
    private boolean emailLogin;
    private Integer nivelPrivilegio;

}
