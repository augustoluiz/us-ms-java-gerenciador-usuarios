package com.pibitaim.us.msjavagerenciadorusuarios.controller;

import com.pibitaim.us.msjavagerenciadorusuarios.data.dto.EmailDTO;
import com.pibitaim.us.msjavagerenciadorusuarios.data.dto.UsuarioDTO;
import com.pibitaim.us.msjavagerenciadorusuarios.data.form.EmailForm;
import com.pibitaim.us.msjavagerenciadorusuarios.data.mapper.EmailMapper;
import com.pibitaim.us.msjavagerenciadorusuarios.service.interfaces.EmailService;
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

@RestController
@RequestMapping("/us-gerenciador-usuarios/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @Autowired
    private EmailMapper emailMapper;

    @GetMapping
    @Cacheable(value = "listaEmails")
    public Page<EmailDTO> findAll(@PageableDefault(sort = "emailUsuario", direction = Sort.Direction.ASC, page = 0, size = 10)Pageable paginacao){
        return emailMapper.converteParaDTO(emailService.findAll(paginacao));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmailDTO> findById(@PathVariable Long id){
        //TODO
        return null;
    }

    @GetMapping("/emailsUsuario/{usuarioCpfCnpj}")
    public ResponseEntity<Page<EmailDTO>> findByUsuarioId(@PathVariable Long cpfCnpj, @PageableDefault(sort = "emailUsuario", direction = Sort.Direction.ASC, page = 0, size = 10) Pageable paginacao){
        //TODO
        return null;
    }

    @GetMapping("/usuariosEmail/{emailId}")
    public ResponseEntity<Page<UsuarioDTO>> findUsuariosByEmailId(@PathVariable Long emailId, @PageableDefault(sort = "CPF_CNPJ", direction = Sort.Direction.ASC, page = 0, size = 10) Pageable paginacao){
        //TODO
        return null;
    }

    @PostMapping
    @Transactional
    @CacheEvict(value = "listaEmails", allEntries = true)
    public ResponseEntity<EmailDTO> save(@RequestBody @Valid EmailForm emailForm){
        //TODO
        return null;
    }

    @PutMapping("/{cpfCnpjUsuario}/{id}")
    @Transactional
    @CacheEvict(value = "listaEmails", allEntries = true)
    public ResponseEntity<EmailDTO> update(@PathVariable Long cpfCnpjUsuario, @PathVariable Long id, @RequestBody @Valid EmailForm emailForm){
        //TODO
        return null;
    }

    @DeleteMapping("/{cpfCnpjUsuario}/{id}")
    @Transactional
    @CacheEvict(value = "listaEmails", allEntries = true)
    public ResponseEntity delete(@PathVariable Long cpfCnpjUsuario, @PathVariable Long id){
        //TODO
        return null;
    }

}
