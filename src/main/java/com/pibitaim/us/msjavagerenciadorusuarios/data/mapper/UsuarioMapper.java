package com.pibitaim.us.msjavagerenciadorusuarios.data.mapper;

import com.pibitaim.us.msjavagerenciadorusuarios.data.dto.UsuarioDTO;
import com.pibitaim.us.msjavagerenciadorusuarios.data.form.UsuarioForm;
import com.pibitaim.us.msjavagerenciadorusuarios.data.mapper.interfaces.MapperDTO;
import com.pibitaim.us.msjavagerenciadorusuarios.data.mapper.interfaces.MapperForm;
import com.pibitaim.us.msjavagerenciadorusuarios.entity.Usuario;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.function.Function;


@Component
public class UsuarioMapper implements MapperDTO<Usuario, UsuarioDTO>, MapperForm<Usuario, UsuarioForm> {

    private static final ModelMapper mapper = new ModelMapper();

    @Override
    public UsuarioDTO converteParaDTO(Usuario usuario) {
        return mapper.typeMap(Usuario.class, UsuarioDTO.class).map(usuario);
    }

    @Override
    public Usuario converteParaEntity(UsuarioForm usuarioForm, String senhaInicial) {
        return mapper.typeMap(UsuarioForm.class, Usuario.class).addMappings(mapper -> {
            mapper.map(src -> senhaInicial, Usuario::setSenhaAcessoUsuario);
        }).map(usuarioForm);
    }


    @Override
    public Page<UsuarioDTO> converteParaDTO(Page<Usuario> usuarios) {
        return usuarios.map(new Function<Usuario, UsuarioDTO>(){
            @Override
            public UsuarioDTO apply(Usuario usuario) {
                return mapper.typeMap(Usuario.class, UsuarioDTO.class).map(usuario);
            }
        });
    }

}
