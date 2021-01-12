package com.pibitaim.us.msjavagerenciadorusuarios.data.mapper;


import com.pibitaim.us.msjavagerenciadorusuarios.data.dto.EnderecosUsuarioDTO;
import com.pibitaim.us.msjavagerenciadorusuarios.data.dto.UsuarioDTO;
import com.pibitaim.us.msjavagerenciadorusuarios.data.mapper.interfaces.MapperDTO;
import com.pibitaim.us.msjavagerenciadorusuarios.entity.EnderecosUsuario;
import com.pibitaim.us.msjavagerenciadorusuarios.entity.Usuario;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UsuarioMapper implements MapperDTO<Usuario, UsuarioDTO> {

    private static final ModelMapper mapper = new ModelMapper();

    @Override
    public UsuarioDTO converteParaDTO(Usuario usuario) {
        return mapper.typeMap(Usuario.class, UsuarioDTO.class)
                .addMappings(mp -> {
                             mp.map(usu -> usu.getCpfCnpj(), UsuarioDTO::setCpfCnpj);
                             mp.map(usu -> usu.getEnumTipoPessoa(), UsuarioDTO::setEnumTipoPessoa);
                             mp.map(usu -> usu.getEnumSexoUsuario(), UsuarioDTO::setEnumSexoUsuario);
                             mp.map(usu -> usu.getDataNascimento(), UsuarioDTO::setDataNascimento);
                             mp.map(usu -> usu.getEnumEstadoCivil(), UsuarioDTO::setEnumEstadoCivil);
                             mp.map(usu -> usu.getIndicadorMembresia(), UsuarioDTO::setIndicadorMembresia);
                             mp.map(usu -> usu.getDataBatismo(), UsuarioDTO::setDataBatismo);
                             mp.map(usu -> usu.getDataUltimaAtualizacao(), UsuarioDTO::setDataUltimaAtualizacao);
                             mp.map(usu -> converteListaEnderecos(usu.getEnderecosUsuario()), UsuarioDTO::setEnderecosUsuario);
                }).map(usuario);
    }

    private List<EnderecosUsuarioDTO> converteListaEnderecos(List<EnderecosUsuario> enderecosUsuario){
        if(enderecosUsuario == null){
            return new ArrayList<>();
        }

        List<EnderecosUsuarioDTO> enderecosUsuarioDTO = new ArrayList<>();

        enderecosUsuario.forEach(endereco -> {
            EnderecosUsuarioDTO endUsuDTO = new EnderecosUsuarioDTO();

            endUsuDTO.setCodigoCadastroEndereco(endereco.getEnderecosUsuarioId().getEndereco().getCodigoCadastroEndereco());
            endUsuDTO.setNivelPrioridade(endereco.getNivelPrioridade());
            endUsuDTO.setEnderecoPrincipal(endereco.getEnderecoPrincipal());
            endUsuDTO.setDataUltimaAtualizacao(endereco.getEnderecosUsuarioId().getEndereco().getDataUltimaAtualizacao());
            endUsuDTO.setCepEndereco(endereco.getEnderecosUsuarioId().getEndereco().getCepEndereco());
            endUsuDTO.setUf(endereco.getEnderecosUsuarioId().getEndereco().getUf());
            endUsuDTO.setMunicipioEndereco(endereco.getEnderecosUsuarioId().getEndereco().getMunicipioEndereco());
            endUsuDTO.setBairroEndereco(endereco.getEnderecosUsuarioId().getEndereco().getBairroEndereco());
            endUsuDTO.setLogradouroEndereco(endereco.getEnderecosUsuarioId().getEndereco().getLogradouroEndereco());
            endUsuDTO.setComplementoEndereco(endereco.getEnderecosUsuarioId().getEndereco().getComplementoEndereco());
            endUsuDTO.setTipoEndereco(endereco.getEnderecosUsuarioId().getEndereco().getTipoEndereco());

            enderecosUsuarioDTO.add(endUsuDTO);
        });

        return enderecosUsuarioDTO;
    }

}
