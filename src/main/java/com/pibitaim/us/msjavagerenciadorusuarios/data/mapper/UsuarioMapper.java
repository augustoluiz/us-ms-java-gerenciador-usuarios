package com.pibitaim.us.msjavagerenciadorusuarios.data.mapper;

import com.pibitaim.us.msjavagerenciadorusuarios.data.dto.UsuarioDTO;
import com.pibitaim.us.msjavagerenciadorusuarios.data.mapper.interfaces.MapperDTO;
import com.pibitaim.us.msjavagerenciadorusuarios.entity.Usuario;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@Component
public class UsuarioMapper implements MapperDTO<Usuario, UsuarioDTO> {

    private static final ModelMapper mapper = new ModelMapper();

    @Override
    public UsuarioDTO converteParaDTO(Usuario usuario) {
        return mapper.typeMap(Usuario.class, UsuarioDTO.class).map(usuario);
    }

}
