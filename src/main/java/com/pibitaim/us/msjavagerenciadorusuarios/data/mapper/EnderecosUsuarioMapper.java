package com.pibitaim.us.msjavagerenciadorusuarios.data.mapper;

import com.pibitaim.us.msjavagerenciadorusuarios.data.form.EnderecosUsuarioForm;
import com.pibitaim.us.msjavagerenciadorusuarios.data.form.UsuarioForm;
import com.pibitaim.us.msjavagerenciadorusuarios.data.mapper.interfaces.MapperEnderecosUsuarioMapper;
import com.pibitaim.us.msjavagerenciadorusuarios.entity.EnderecosUsuario;
import com.pibitaim.us.msjavagerenciadorusuarios.entity.EnderecosUsuarioId;
import com.pibitaim.us.msjavagerenciadorusuarios.entity.Usuario;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class EnderecosUsuarioMapper implements MapperEnderecosUsuarioMapper<EnderecosUsuario, EnderecosUsuarioForm> {

    private static final ModelMapper mapper = new ModelMapper();

    @Override
    public EnderecosUsuario converteParaEntity(EnderecosUsuarioForm enderecosUsuarioForm) {
        return mapper.map(enderecosUsuarioForm, EnderecosUsuario.class);
    }
}
