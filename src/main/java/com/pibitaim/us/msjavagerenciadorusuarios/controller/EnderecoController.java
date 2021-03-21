package com.pibitaim.us.msjavagerenciadorusuarios.controller;

import com.pibitaim.us.msjavagerenciadorusuarios.controller.utils.UsuarioUtils;
import com.pibitaim.us.msjavagerenciadorusuarios.data.dto.EnderecoDTO;
import com.pibitaim.us.msjavagerenciadorusuarios.data.dto.UsuarioDTO;
import com.pibitaim.us.msjavagerenciadorusuarios.data.mapper.EnderecoMapper;
import com.pibitaim.us.msjavagerenciadorusuarios.entity.Endereco;
import com.pibitaim.us.msjavagerenciadorusuarios.service.interfaces.EnderecoService;
import com.pibitaim.us.msjavagerenciadorusuarios.service.interfaces.UsuarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/us-gerenciador-usuarios/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private EnderecoMapper enderecoMapper;

    @GetMapping
    @Cacheable(value = "listaEnderecos")
    public Page<EnderecoDTO> findAll(@PageableDefault(sort = "cepEndereco", direction = Sort.Direction.ASC, page = 0, size = 10) Pageable paginacao){
        return enderecoMapper.converteParaDTO(enderecoService.findAll(paginacao));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnderecoDTO> findById(@PathVariable Long id){
        Optional<Endereco> endereco = enderecoService.findById(id);
        return endereco.isPresent() ? new ResponseEntity<EnderecoDTO>(enderecoMapper.converteParaDTO(endereco.get()), HttpStatus.OK) : ResponseEntity.notFound().build();
    }

    @GetMapping("/enderecosUsuario/{usuarioCpfCnpj}")
    public ResponseEntity<Page<EnderecoDTO>> findByUsuarioId(@PathVariable Long usuarioCpfCnpj, @PageableDefault(sort = "cep_end", direction = Sort.Direction.ASC, page = 0, size = 10) Pageable paginacao){
        if (!UsuarioUtils.usuarioExiste(usuarioService, usuarioCpfCnpj)){
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<Page<EnderecoDTO>>(enderecoMapper.converteParaDTO(enderecoService.findByUsuarioId(paginacao, usuarioCpfCnpj)), HttpStatus.OK);
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

    private boolean enderecoExiste(Long id){
        return enderecoService.findById(id).isPresent();
    }

}
