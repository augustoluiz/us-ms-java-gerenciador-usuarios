package com.pibitaim.us.msjavagerenciadorusuarios.data.mapper;

import com.pibitaim.us.msjavagerenciadorusuarios.data.dto.EnderecoDTO;
import com.pibitaim.us.msjavagerenciadorusuarios.data.mapper.interfaces.MapperDTO;
import com.pibitaim.us.msjavagerenciadorusuarios.entity.Endereco;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class EnderecoMapper implements MapperDTO<Endereco, EnderecoDTO> {

    private static final ModelMapper mapper = new ModelMapper();

    @Override
    public EnderecoDTO converteParaDTO(Endereco e) {
        return mapper.map(e, EnderecoDTO.class);
    }

    @Override
    public Page<EnderecoDTO> converteParaDTO(Page<Endereco> enderecos) {
        return enderecos.map(new Function<Endereco, EnderecoDTO>(){
            @Override
            public EnderecoDTO apply(Endereco endereco) {
                return mapper.map(endereco, EnderecoDTO.class);
            }
        });
    }
}
