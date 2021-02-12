package com.pibitaim.us.msjavagerenciadorusuarios.controller;

import com.pibitaim.us.msjavagerenciadorusuarios.data.dto.UsuarioDTO;
import com.pibitaim.us.msjavagerenciadorusuarios.data.mapper.UsuarioMapper;
import com.pibitaim.us.msjavagerenciadorusuarios.entity.Usuario;
import com.pibitaim.us.msjavagerenciadorusuarios.service.interfaces.UsuarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping(value = "/us-gerenciador-usuarios/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuarioMapper usuarioMapper;

    @GetMapping
    @Cacheable(value = "listaUsuarios")
    public Page<UsuarioDTO> findAll(@PageableDefault(sort = "cpfCnpj", direction = Sort.Direction.ASC, page = 0, size = 10)Pageable paginacao){
        return usuarioMapper.converteParaDTO(usuarioService.findAll(paginacao));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> findById(@PathVariable Long id){
        Optional<Usuario> usuario = usuarioService.findById(id);
        if (usuario.isPresent()){
            return ResponseEntity.ok(usuarioMapper.converteParaDTO(usuario.get()));
        }
        return ResponseEntity.notFound().build();
    }
}
