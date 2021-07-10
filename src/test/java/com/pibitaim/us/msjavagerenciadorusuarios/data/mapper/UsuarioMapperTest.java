package com.pibitaim.us.msjavagerenciadorusuarios.data.mapper;

import com.pibitaim.us.msjavagerenciadorusuarios.data.dto.UsuarioDTO;
import com.pibitaim.us.msjavagerenciadorusuarios.data.form.UsuarioForm;
import com.pibitaim.us.msjavagerenciadorusuarios.data.form.UsuarioFormPerfil;
import com.pibitaim.us.msjavagerenciadorusuarios.entity.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = {
        UsuarioMapper.class,
        Usuario.class,
        UsuarioDTO.class,
        UsuarioForm.class,
        UsuarioFormPerfil.class
})
public class UsuarioMapperTest {

    private final String EMAIL_CADASTRO_UPPER = "EMAIL@TESTE.COM";
    private final String EMAIL_CADASTRO_LOWER = "email@teste.com";

    @Mock
    private Usuario usuario;

    @Mock
    private Page<Usuario> usuarios;

    @Mock
    private UsuarioForm usuarioForm;

    @Mock
    private UsuarioFormPerfil usuarioFormPerfil;

    @Mock
    private UsuarioMapper usuarioMapper;

    @Test
    @DisplayName("deveEfetuarConversaoParaDTO: Deve efetuar a conversao de Usuario para UsuaioDTO")
    public void deveEfetuarConversaoDeUsuarioParaUsuarioDTO(){
        when(usuarioMapper.converteParaDTO(any(Usuario.class))).thenReturn(new UsuarioDTO());
        assertEquals(UsuarioDTO.class, usuarioMapper.converteParaDTO(usuario).getClass());
    }

    @Test
    @DisplayName("naoDeveEfetuarConversaoDeUsuarioParaUsuarioDTO: Não deve efetuar a conversao de Usuario para UsuaioDTO")
    public void naoDeveEfetuarConversaoDeUsuarioParaUsuarioDTO(){
        when(usuarioMapper.converteParaDTO(any(Usuario.class))).thenReturn(null);
        assertNull(usuarioMapper.converteParaDTO(usuario));
    }

    @Test
    @DisplayName("deveEfetuarConversaoDeUsuarioFormParaEntity: Deve efetuar a conversao de UsuarioForm para Usuario")
    public void deveEfetuarConversaoDeUsuarioFormParaEntity(){
        UsuarioForm uFm = new UsuarioForm();
        uFm.setEmailUsuario(EMAIL_CADASTRO_UPPER);

        Usuario usuario = new UsuarioMapper().converteParaEntity(uFm, "teste");

        assertTrue(usuario instanceof Usuario);
        assertEquals("teste", usuario.getSenhaAcessoUsuario());
        assertNotNull(usuario.getDataUltimaAtualizacao());
        assertEquals(EMAIL_CADASTRO_LOWER, usuario.getEmailUsuario());
    }

    @Test
    @DisplayName("naoDeveEfetuarConversaoDeUsuarioFormParaEntity: Não deve efetuar a conversao de UsuarioForm para Usuario")
    public void naoDeveEfetuarConversaoDeUsuarioFormParaEntity(){
        when(usuarioMapper.converteParaEntity(any(UsuarioForm.class), any(String.class))).thenReturn(null);
        assertNull(usuarioMapper.converteParaEntity(usuarioForm, "teste"));
    }

    @Test
    @DisplayName("deveEfetuarConversaoDeUsuarioperfilParaEntity: Deve efetuar a conversao de UsuarioFormPerfil para Usuario")
    public void deveEfetuarConversaoDeUsuarioFormPerfilParaEntity(){
        UsuarioFormPerfil uFP = new UsuarioFormPerfil();
        uFP.setEmailUsuario(EMAIL_CADASTRO_UPPER);

        Usuario usuario = new UsuarioMapper().converteParaEntity(uFP, "teste");

        assertTrue(usuario instanceof Usuario);
        assertEquals("teste", usuario.getSenhaAcessoUsuario());
        assertNotNull(usuario.getDataUltimaAtualizacao());
        assertEquals(EMAIL_CADASTRO_LOWER, usuario.getEmailUsuario());
    }

    @Test
    @DisplayName("naoDeveEfetuarConversaoDeUsuarioFormPerfilParaEntity: Não deve efetuar a conversao de UsuarioFormPerfil para Usuario")
    public void naoDeveEfetuarConversaoDeUsuarioFormPerfilParaEntity(){
        when(usuarioMapper.converteParaEntity(any(UsuarioFormPerfil.class), any(String.class))).thenReturn(null);
        assertNull(usuarioMapper.converteParaEntity(new UsuarioFormPerfil(), "teste"));
    }

    @Test
    @DisplayName("deveEfetuarConversaoDePageUsuarioParaUsuarioDTO: Deve efetuar a conversao de Page<Usuario> para UsuaioDTO")
    public void deveEfetuarConversaoDePageUsuarioParaUsuarioDTO(){
        List listUsuarios = new ArrayList();
        Page<UsuarioDTO> usuariosPage = new PageImpl<UsuarioDTO>(listUsuarios);
        when(usuarioMapper.converteParaDTO(any(Page.class))).thenReturn(usuariosPage);
        assertTrue(usuarioMapper.converteParaDTO(usuarios) instanceof Page);
    }

    @Test
    @DisplayName("naoDeveEfetuarConversaoDePageUsuarioParaUsuarioDTO: Não deve efetuar a conversao de Page<Usuario> para UsuaioDTO")
    public void naoDeveEfetuarConversaoDePageUsuarioParaUsuarioDTO(){
        when(usuarioMapper.converteParaDTO(any(Page.class))).thenReturn(null);
        assertNull(usuarioMapper.converteParaDTO(usuarios));
    }


}