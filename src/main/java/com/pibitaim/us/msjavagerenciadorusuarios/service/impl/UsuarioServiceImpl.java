package com.pibitaim.us.msjavagerenciadorusuarios.service.impl;

import com.pibitaim.us.msjavagerenciadorusuarios.data.form.UsuarioForm;
import com.pibitaim.us.msjavagerenciadorusuarios.entity.Usuario;
import com.pibitaim.us.msjavagerenciadorusuarios.repository.UsuarioRepository;
import com.pibitaim.us.msjavagerenciadorusuarios.service.interfaces.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Page<Usuario> findAll(Pageable paginacao) {
        return usuarioRepository.findAll(paginacao);
    }

    @Override
    public Optional<Usuario> findById(Long id) {
        return usuarioRepository.findById(id);
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
                                        usuarioForm.getEnumEstadoCivil().toString(),
                                        usuarioForm.getEnumSexoUsuario().toString(),
                                        usuarioForm.getEnumTipoPessoa().toString(),
                                        usuarioForm.getIndicadorMembresia(),
                                        usuarioForm.getNomeUsuario(),
                                        cpfCnpjOriginal);
    }

    @Override
    public void deleteByCpfCnpj(Long cpfCnpj) {
        usuarioRepository.deleteByCpfCnpj(cpfCnpj);
    }

}
