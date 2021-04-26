package com.pibitaim.us.msjavagerenciadorusuarios.controller;

import com.pibitaim.us.msjavagerenciadorusuarios.data.dto.PerfilDTO;
import com.pibitaim.us.msjavagerenciadorusuarios.data.mapper.PerfilMapper;
import com.pibitaim.us.msjavagerenciadorusuarios.entity.Perfil;
import com.pibitaim.us.msjavagerenciadorusuarios.service.interfaces.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/us-gerenciador-usuarios/perfil")
public class PerfilController {

    @Autowired
    private PerfilService perfilService;

    @Autowired
    private PerfilMapper perfilMapper;

    @GetMapping
    @Cacheable(value = "listaPerfis")
    public Page<PerfilDTO> findAll(@PageableDefault(sort = "perfilId", direction = Sort.Direction.ASC, page = 0, size = 10) Pageable paginacao){
        return perfilMapper.converteParaDTO(perfilService.findAll(paginacao)) ;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PerfilDTO> findById(@PathVariable Long id){
        Optional<Perfil> perfil = perfilService.findById(id);
        return perfil.isPresent() ? new ResponseEntity<PerfilDTO>(perfilMapper.converteParaDTO(perfil.get()), HttpStatus.OK) : ResponseEntity.notFound().build();
    }

}
