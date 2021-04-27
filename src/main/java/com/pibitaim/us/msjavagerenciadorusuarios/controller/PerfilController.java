package com.pibitaim.us.msjavagerenciadorusuarios.controller;

import com.pibitaim.us.msjavagerenciadorusuarios.controller.utils.PerfilUtils;
import com.pibitaim.us.msjavagerenciadorusuarios.controller.utils.TelefoneUtils;
import com.pibitaim.us.msjavagerenciadorusuarios.controller.utils.UsuarioUtils;
import com.pibitaim.us.msjavagerenciadorusuarios.data.dto.PerfilDTO;
import com.pibitaim.us.msjavagerenciadorusuarios.data.dto.TelefoneDTO;
import com.pibitaim.us.msjavagerenciadorusuarios.data.dto.UsuarioDTO;
import com.pibitaim.us.msjavagerenciadorusuarios.data.form.PerfilForm;
import com.pibitaim.us.msjavagerenciadorusuarios.data.form.TelefoneForm;
import com.pibitaim.us.msjavagerenciadorusuarios.data.form.TelefonesUsuarioForm;
import com.pibitaim.us.msjavagerenciadorusuarios.data.mapper.PerfilMapper;
import com.pibitaim.us.msjavagerenciadorusuarios.data.mapper.UsuarioMapper;
import com.pibitaim.us.msjavagerenciadorusuarios.entity.Perfil;
import com.pibitaim.us.msjavagerenciadorusuarios.entity.Telefone;
import com.pibitaim.us.msjavagerenciadorusuarios.entity.Usuario;
import com.pibitaim.us.msjavagerenciadorusuarios.service.interfaces.PerfilService;
import com.pibitaim.us.msjavagerenciadorusuarios.service.interfaces.UsuarioService;
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
import sun.misc.Perf;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping(value = "/us-gerenciador-usuarios/perfil")
public class PerfilController {

    @Autowired
    private PerfilService perfilService;

    @Autowired
    private PerfilMapper perfilMapper;

    @Autowired
    private UsuarioMapper usuarioMapper;

    @Autowired
    private UsuarioService usuarioService;

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

    @GetMapping("/perfisUsuario/{usuarioCpfCnpj}")
    public ResponseEntity<Page<PerfilDTO>> findByUsuarioId(@PathVariable Long usuarioCpfCnpj, @PageableDefault(sort = "COD_CAD_PER", direction = Sort.Direction.ASC, page = 0, size = 10) Pageable paginacao){
        if(!UsuarioUtils.usuarioExiste(usuarioService, usuarioCpfCnpj)){
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<Page<PerfilDTO>>(perfilMapper.converteParaDTO(perfilService.findByUsuarioId(paginacao, usuarioCpfCnpj)), HttpStatus.OK);
    }

    @GetMapping("/usuariosPerfil/{id}")
    public ResponseEntity<Page<UsuarioDTO>> findUsuariosByTelefoneId(@PathVariable Long id, @PageableDefault(sort = "CPF_CNPJ", direction = Sort.Direction.ASC, page = 0, size = 10) Pageable paginacao){
        if(!PerfilUtils.perfilExiste(perfilService, id)){
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<Page<UsuarioDTO>>(usuarioMapper.converteParaDTO(usuarioService.findByPerfilId(paginacao, id)), HttpStatus.OK);
    }

    @PostMapping
    @Transactional
    @CacheEvict(value = "listaPerfis", allEntries = true)
    public ResponseEntity<PerfilDTO> save(@RequestBody @Valid PerfilForm perfilForm){
        if(PerfilUtils.perfilExiste(perfilService, perfilForm.getPapel(), perfilForm.getPermissao())){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        return new ResponseEntity<PerfilDTO>(perfilMapper.converteParaDTO(perfilService.save(perfilMapper.converteParaEntity(perfilForm))), HttpStatus.CREATED);
    }

}
