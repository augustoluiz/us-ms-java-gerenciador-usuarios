package com.pibitaim.us.msjavagerenciadorusuarios.data.mapper;

import com.pibitaim.us.msjavagerenciadorusuarios.controller.utils.UsuarioUtils;
import com.pibitaim.us.msjavagerenciadorusuarios.data.dto.EmailDTO;
import com.pibitaim.us.msjavagerenciadorusuarios.data.form.EmailForm;
import com.pibitaim.us.msjavagerenciadorusuarios.data.mapper.interfaces.MapperDTO;
import com.pibitaim.us.msjavagerenciadorusuarios.entity.Email;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class EmailMapper implements MapperDTO<Email, EmailDTO> {

    private static final ModelMapper mapper = new ModelMapper();

    @Override
    public EmailDTO converteParaDTO(Email email) {
        return mapper.typeMap(Email.class, EmailDTO.class).map(email);
    }

    @Override
    public Page<EmailDTO> converteParaDTO(Page<Email> emails) {
        return emails.map(new Function<Email, EmailDTO>() {
            @Override
            public EmailDTO apply(Email email) {
                return mapper.typeMap(Email.class, EmailDTO.class).addMappings(mapper -> {
                    mapper.map(src -> src.getUsuario().getCpfCnpj(), EmailDTO::setCpfCnpjUsuario);
                }).map(email);
            }
        });
    }
}
