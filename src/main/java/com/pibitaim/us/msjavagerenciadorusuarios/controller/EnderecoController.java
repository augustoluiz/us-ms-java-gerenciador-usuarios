package com.pibitaim.us.msjavagerenciadorusuarios.controller;

import com.pibitaim.us.msjavagerenciadorusuarios.data.dto.EnderecoDTO;
import com.pibitaim.us.msjavagerenciadorusuarios.data.dto.UsuarioDTO;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/us-gerenciador-usuarios/endereco")
public class EnderecoController {

    @GetMapping
    @Cacheable(value = "listaEnderecos")
    public Page<EnderecoDTO> findAll(){
        //TODO
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnderecoDTO> findById(){
        //TODO
        return null;
    }

    @GetMapping("/enderecosUsuario/{usuarioId}")
    public Page<EnderecoDTO> findByUsuarioId(){
        //TODO
        return null;
    }

    @GetMapping("/usuariosEndereco/{id}")
    public Page<UsuarioDTO> findUsuariosByEnderecoId(){
        //TODO
        return null;
    }

    @PostMapping
    @CacheEvict(value = "listaEnderecos")
    public ResponseEntity<EnderecoDTO> save(){
        //TODO
        return null;
    }

    @PutMapping("/{id}")
    @CacheEvict(value = "listaEnderecos")
    public ResponseEntity<EnderecoDTO> update(){
        //TODO
        return null;
    }

}
