package com.pibitaim.us.msjavagerenciadorusuarios.controller;

import com.pibitaim.us.msjavagerenciadorusuarios.controller.utils.UsuarioUtils;
import com.pibitaim.us.msjavagerenciadorusuarios.data.dto.UsuarioDTO;
import com.pibitaim.us.msjavagerenciadorusuarios.data.form.UsuarioForm;
import com.pibitaim.us.msjavagerenciadorusuarios.data.form.UsuarioSenhaForm;
import com.pibitaim.us.msjavagerenciadorusuarios.data.mapper.UsuarioMapper;
import com.pibitaim.us.msjavagerenciadorusuarios.entity.Usuario;
import com.pibitaim.us.msjavagerenciadorusuarios.service.interfaces.UsuarioService;
import com.pibitaim.us.msjavagerenciadorusuarios.utils.EncoderMD5;
import com.pibitaim.us.msjavagerenciadorusuarios.utils.SenhaInicial;
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

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.security.NoSuchAlgorithmException;
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

    @GetMapping("/{cpfCnpj}")
    public ResponseEntity<UsuarioDTO> findById(@PathVariable Long cpfCnpj){
        Optional<Usuario> usuario = usuarioService.findByCpfCnpj(cpfCnpj);
        if (usuario.isPresent()){
            return ResponseEntity.ok(usuarioMapper.converteParaDTO(usuario.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @Transactional
    @CacheEvict(value = "listaUsuarios", allEntries = true)
    public ResponseEntity<UsuarioDTO> save(@RequestBody @Valid UsuarioForm usuarioForm) throws NoSuchAlgorithmException {
        if(UsuarioUtils.usuarioExiste(usuarioService, usuarioForm.getCpfCnpj())){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        String senhaInicial = new SenhaInicial().geraSenhaInicial();
        return new ResponseEntity<UsuarioDTO>(usuarioMapper.converteParaDTO(usuarioService.save(usuarioMapper.converteParaEntity(usuarioForm, senhaInicial))), HttpStatus.CREATED);
    }

    @PutMapping("/{cpfCnpj}")
    @Transactional
    @CacheEvict(value = "listaUsuarios", allEntries = true)
    public ResponseEntity<UsuarioDTO> update(@PathVariable Long cpfCnpj, @RequestBody @Valid UsuarioForm usuarioForm){
        if (UsuarioUtils.usuarioExiste(usuarioService, cpfCnpj)){
            usuarioService.update(usuarioForm, cpfCnpj);
            return new ResponseEntity<UsuarioDTO>(usuarioMapper.converteParaDTO(usuarioService.findByCpfCnpj(usuarioForm.getCpfCnpj()).get()), HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

    @PatchMapping("/alteraSenha/{cpfCnpj}")
    @Transactional
    @CacheEvict(value = "listaUsuarios", allEntries = true)
    public ResponseEntity alteraSenha(@PathVariable Long cpfCnpj, @RequestBody @Valid UsuarioSenhaForm usuarioSenhaForm) throws NoSuchAlgorithmException {
        if(validaUsuarioESenha(cpfCnpj, usuarioSenhaForm.getSenhaAtual())){
            usuarioService.updateSenha(cpfCnpj, usuarioSenhaForm.getNovaSenha());
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{cpfCnpj}")
    @Transactional
    @CacheEvict(value = "listaUsuarios", allEntries = true)
    public ResponseEntity delete(@PathVariable Long cpfCnpj){
        if (UsuarioUtils.usuarioExiste(usuarioService, cpfCnpj)){
            usuarioService.deleteByCpfCnpj(cpfCnpj);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    private boolean validaUsuarioESenha(Long cpfCnpj, String senhaAtual) throws NoSuchAlgorithmException {
        try{
            senhaAtual = new EncoderMD5().encodeToMD5(senhaAtual);
            return usuarioService.findByCpfCnpjAndSenha(cpfCnpj, senhaAtual).isPresent();
        }catch (NoSuchAlgorithmException exception) {
            throw new NoSuchAlgorithmException("Erro de validações internas");
        }
    }

}
