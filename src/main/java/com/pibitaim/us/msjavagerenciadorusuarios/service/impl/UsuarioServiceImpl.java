package com.pibitaim.us.msjavagerenciadorusuarios.service.impl;

import com.pibitaim.us.msjavagerenciadorusuarios.data.form.UsuarioForm;
import com.pibitaim.us.msjavagerenciadorusuarios.entity.Usuario;
import com.pibitaim.us.msjavagerenciadorusuarios.repository.UsuarioRepository;
import com.pibitaim.us.msjavagerenciadorusuarios.service.interfaces.UsuarioService;
import com.pibitaim.us.msjavagerenciadorusuarios.utils.EncoderMD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Optional<UUID> findCodUsuarioByCpfCnpj(Long cpfCnpj) {
        return usuarioRepository.findCodUsuarioByCpfCnpj(cpfCnpj);
    }

    @Override
    public Page<Usuario> findAll(Pageable paginacao) {
        return usuarioRepository.findAll(paginacao);
    }

    @Override
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Optional<Usuario> findByCpfCnpj(Long cpfCnpj) {
        return usuarioRepository.findByCpfCnpj(cpfCnpj);
    }

    @Override
    public void update(UsuarioForm usuarioForm, Long cpfCnpjOriginal) {
            usuarioRepository.update(usuarioForm.getCpfCnpj(),
                                        usuarioForm.getDataBatismo(),
                                        usuarioForm.getDataNascimento(),
                                        usuarioForm.getEstadoCivil().toString(),
                                        usuarioForm.getSexoUsuario().toString(),
                                        usuarioForm.getTipoPessoa().toString(),
                                        usuarioForm.getIndicadorMembresia(),
                                        usuarioForm.getNomeUsuario(),
                                        cpfCnpjOriginal);
    }

    @Override
    public void deleteByCpfCnpj(Long cpfCnpj) {
        usuarioRepository.deleteByCpfCnpj(cpfCnpj);
    }

    @Override
    public Optional<Usuario> findByCpfCnpjAndSenha(Long cpfCnpj, String senhaAtual) {
        return usuarioRepository.findByCpfCnpjAndSenha(cpfCnpj, senhaAtual);
    }

    @Override
    public void updateSenha(Long cpfCnpj, String novaSenha) throws NoSuchAlgorithmException {
        try {
            novaSenha = new EncoderMD5().encodeToMD5(novaSenha);
            usuarioRepository.updateSenha(cpfCnpj, novaSenha, new Date());
        } catch (NoSuchAlgorithmException exception) {
            throw new NoSuchAlgorithmException("Erro inesperado ao salvar o dado");
        }
    }

    @Override
    public Page<Usuario> findByEnderecoId(Pageable paginacao, Long enderecoId) {
        return usuarioRepository.findByEnderecoId(paginacao, enderecoId);
    }

}
