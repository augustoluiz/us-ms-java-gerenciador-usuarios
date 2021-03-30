package com.pibitaim.us.msjavagerenciadorusuarios.data.mapper;

import com.pibitaim.us.msjavagerenciadorusuarios.data.dto.TelefoneDTO;
import com.pibitaim.us.msjavagerenciadorusuarios.data.mapper.interfaces.MapperDTO;
import com.pibitaim.us.msjavagerenciadorusuarios.entity.Telefone;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class TelefoneMapper implements MapperDTO<Telefone, TelefoneDTO> {

    private static final ModelMapper mapper = new ModelMapper();

    @Override
    public TelefoneDTO converteParaDTO(Telefone telefone) {
        return mapper.typeMap(Telefone.class, TelefoneDTO.class).map(telefone);
    }

    @Override
    public Page<TelefoneDTO> converteParaDTO(Page<Telefone> telefones) {
        return telefones.map(new Function<Telefone, TelefoneDTO>(){
            @Override
            public TelefoneDTO apply(Telefone telefone) {
                return mapper.map(telefone, TelefoneDTO.class);
            }
        });
    }

}
