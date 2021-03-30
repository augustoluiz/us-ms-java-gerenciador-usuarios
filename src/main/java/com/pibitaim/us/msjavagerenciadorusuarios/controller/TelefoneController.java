package com.pibitaim.us.msjavagerenciadorusuarios.controller;

import com.pibitaim.us.msjavagerenciadorusuarios.data.dto.TelefoneDTO;
import com.pibitaim.us.msjavagerenciadorusuarios.data.dto.UsuarioDTO;
import com.pibitaim.us.msjavagerenciadorusuarios.data.form.TelefoneForm;
import com.pibitaim.us.msjavagerenciadorusuarios.data.mapper.TelefoneMapper;
import com.pibitaim.us.msjavagerenciadorusuarios.service.interfaces.TelefoneService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping(value = "/us-gerenciador-usuarios/telefone")
public class TelefoneController {

    @Autowired
    private TelefoneService telefoneService;

    @Autowired
    private TelefoneMapper telefoneMapper;

    @GetMapping
    @Cacheable(value = "listaTelefones")
    public Page<TelefoneDTO> findAll(@PageableDefault(sort = "telefoneNumero", direction = Sort.Direction.ASC, page = 0, size = 10)Pageable paginacao){
        return telefoneMapper.converteParaDTO(telefoneService.findAll(paginacao)) ;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TelefoneDTO> findById(@PathVariable Long id){
        //TODO
        return null;
    }

    @GetMapping("/telefonesUsuario/{usuarioCpfCnpj}")
    public ResponseEntity<TelefoneDTO> findByUsuarioId(@PathVariable Long usuarioCpfCnpj, @PageableDefault(sort = "TEL_NUM", direction = Sort.Direction.ASC, page = 0, size = 10) Pageable paginacao){
        //TODO
        return null;
    }

    @GetMapping("/telefonesUsuario/{telefoneId}")
    public ResponseEntity<Page<UsuarioDTO>> findUsuariosByTelefoneId(@PathVariable Long telefoneId, @PageableDefault(sort = "CPF_CNPJ", direction = Sort.Direction.ASC, page = 0, size = 10) Pageable paginacao){
        //TODO
        return null;
    }

    @PostMapping
    @Transactional
    @CacheEvict(value = "listaTelefones", allEntries = true)
    public ResponseEntity<TelefoneDTO> save(@RequestBody @Valid TelefoneForm telefoneForm){
        //TODO
        return null;
    }

    @PutMapping("/{cpfCnpjUsuario}/{id}")
    @Transactional
    @CacheEvict(value = "listaTelefones", allEntries = true)
    public ResponseEntity<TelefoneDTO> update(@PathVariable Long cpfCnpjUsuario, @PathVariable Long id, @RequestBody @Valid TelefoneForm telefoneForm){
        //TODO
        return null;
    }

    @DeleteMapping("/{id}")
    @Transactional
    @CacheEvict(value = "listaTelefones", allEntries = true)
    public ResponseEntity delete(@PathVariable Long id){
        //TODO
        return null;
    }

}
