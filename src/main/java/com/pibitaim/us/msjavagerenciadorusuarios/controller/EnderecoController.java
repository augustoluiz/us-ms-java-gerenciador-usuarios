package com.pibitaim.us.msjavagerenciadorusuarios.controller;

import com.pibitaim.us.msjavagerenciadorusuarios.data.dto.EnderecoDTO;
import com.pibitaim.us.msjavagerenciadorusuarios.data.dto.UsuarioDTO;
import com.pibitaim.us.msjavagerenciadorusuarios.data.mapper.EnderecoMapper;
import com.pibitaim.us.msjavagerenciadorusuarios.service.interfaces.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/us-gerenciador-usuarios/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    private EnderecoMapper enderecoMapper;

    @GetMapping
    @Cacheable(value = "listaEnderecos")
    public Page<EnderecoDTO> findAll(@PageableDefault(sort = "cepEndereco", direction = Sort.Direction.ASC, page = 0, size = 10) Pageable paginacao){
        return enderecoMapper.converteParaDTO(enderecoService.findAll(paginacao));
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
