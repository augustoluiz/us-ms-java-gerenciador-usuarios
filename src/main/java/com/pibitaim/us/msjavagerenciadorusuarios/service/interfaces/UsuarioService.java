package com.pibitaim.us.msjavagerenciadorusuarios.service.interfaces;

import com.pibitaim.us.msjavagerenciadorusuarios.data.form.UsuarioForm;
import com.pibitaim.us.msjavagerenciadorusuarios.entity.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Optional;

public interface UsuarioService {

    Page<Usuario> findAll(Pageable paginacao);

    Optional<Usuario> findById(Long id);

    Usuario save(Usuario usuario);

    Optional<Usuario> findByCpfCnpj(Long cpfCnpj);

    void update(UsuarioForm usuarioForm, Long cpfCnpjOriginal);

    void deleteByCpfCnpj(Long cpfCnpj);

}
