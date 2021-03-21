package com.pibitaim.us.msjavagerenciadorusuarios.controller;

import com.pibitaim.us.msjavagerenciadorusuarios.controller.utils.EnderecoUtils;
import com.pibitaim.us.msjavagerenciadorusuarios.controller.utils.UsuarioUtils;
import com.pibitaim.us.msjavagerenciadorusuarios.data.dto.EnderecoDTO;
import com.pibitaim.us.msjavagerenciadorusuarios.data.dto.UsuarioDTO;
import com.pibitaim.us.msjavagerenciadorusuarios.data.form.EnderecoForm;
import com.pibitaim.us.msjavagerenciadorusuarios.data.form.EnderecosUsuarioForm;
import com.pibitaim.us.msjavagerenciadorusuarios.data.mapper.EnderecoMapper;
import com.pibitaim.us.msjavagerenciadorusuarios.data.mapper.EnderecosUsuarioMapper;
import com.pibitaim.us.msjavagerenciadorusuarios.data.mapper.UsuarioMapper;
import com.pibitaim.us.msjavagerenciadorusuarios.entity.Endereco;
import com.pibitaim.us.msjavagerenciadorusuarios.service.interfaces.EnderecoService;
import com.pibitaim.us.msjavagerenciadorusuarios.service.interfaces.EnderecosUsuarioService;
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

import javax.transaction.Transactional;
import javax.validation.Valid;
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
    private EnderecosUsuarioService enderecosUsuarioService;

    @Autowired
    private EnderecoMapper enderecoMapper;

    @Autowired
    private UsuarioMapper usuarioMapper;

    @Autowired
    private EnderecosUsuarioMapper enderecosUsuarioMapper;

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
    public ResponseEntity<Page<EnderecoDTO>> findByUsuarioId(@PathVariable Long usuarioCpfCnpj, @PageableDefault(sort = "CEP_END", direction = Sort.Direction.ASC, page = 0, size = 10) Pageable paginacao){
        if (!UsuarioUtils.usuarioExiste(usuarioService, usuarioCpfCnpj)){
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<Page<EnderecoDTO>>(enderecoMapper.converteParaDTO(enderecoService.findByUsuarioId(paginacao, usuarioCpfCnpj)), HttpStatus.OK);
    }

    @GetMapping("/usuariosEndereco/{enderecoId}")
    public ResponseEntity<Page<UsuarioDTO>> findUsuariosByEnderecoId(@PathVariable Long enderecoId, @PageableDefault(sort = "CPF_CNPJ", direction = Sort.Direction.ASC, page = 0, size = 10) Pageable paginacao){
        if(!EnderecoUtils.enderecoExiste(enderecoService, enderecoId)){
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<Page<UsuarioDTO>>(usuarioMapper.converteParaDTO(usuarioService.findByEnderecoId(paginacao, enderecoId)), HttpStatus.OK);
    }

    @PostMapping
    @Transactional
    @CacheEvict(value = "listaEnderecos", allEntries = true)
    public ResponseEntity<EnderecoDTO> save(@RequestBody @Valid EnderecoForm enderecoForm){
        if(!UsuarioUtils.usuarioExiste(usuarioService, enderecoForm.getCpfCnpjUsuario())){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        Endereco endereco = enderecoService.save(enderecoMapper.converteParaEntity(enderecoForm));
        EnderecoDTO enderecoDTO = enderecoMapper.converteParaDTO(endereco);

        EnderecosUsuarioForm enderecosUsuarioForm = new EnderecosUsuarioForm();
        enderecosUsuarioForm.setCodigoCadastroEndereco(endereco.getCodigoCadastroEndereco());
        enderecosUsuarioForm.setCpfCnpjUsuario(enderecoForm.getCpfCnpjUsuario());

        boolean existeEnderecosCadastrados = EnderecoUtils.existeEnderecosCadastradosParaCpfCnpj(enderecosUsuarioService, enderecoForm.getCpfCnpjUsuario());

        if(enderecoForm.isEnderecoPrincipal() && existeEnderecosCadastrados){
            enderecosUsuarioService.atualizaEnderecosPrincipais(enderecoForm.getCpfCnpjUsuario());
        } else if(!existeEnderecosCadastrados && !enderecoForm.isEnderecoPrincipal()){
            enderecoForm.setEnderecoPrincipal(true);
        }

        enderecosUsuarioForm.setEnderecoPrincipal(enderecoForm.isEnderecoPrincipal());

        Integer nivelPrioridade = EnderecoUtils.qtdEnderecosPorCpfCnpj(enderecosUsuarioService, enderecoForm.getCpfCnpjUsuario()) == 0 ? 1
                                : EnderecoUtils.getUltimoNivelPrioridade(enderecosUsuarioService, enderecoForm.getCpfCnpjUsuario()) + 1;

        enderecosUsuarioForm.setNivelPrioridade(nivelPrioridade);

        enderecosUsuarioService.save(enderecosUsuarioMapper.converteParaEntity(enderecosUsuarioForm));

        return new ResponseEntity<EnderecoDTO>(enderecoDTO, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @CacheEvict(value = "listaEnderecos", allEntries = true)
    public ResponseEntity<EnderecoDTO> update(){
        //TODO
        return null;
    }

}
