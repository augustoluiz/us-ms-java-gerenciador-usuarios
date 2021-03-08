package com.pibitaim.us.msjavagerenciadorusuarios.repository;

import com.pibitaim.us.msjavagerenciadorusuarios.entity.EnderecosUsuario;
import com.pibitaim.us.msjavagerenciadorusuarios.entity.EnderecosUsuarioId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface EnderecosUsuarioRepository extends JpaRepository<EnderecosUsuario, EnderecosUsuarioId> {

    @Query(value = "SELECT * FROM TBUS005_END_USU " +
            "WHERE CPF_CNPJ = :cpfCnpj" +
            "  AND COD_CAD_END = :codigoCadastroEndereco", nativeQuery = true)
    Optional<EnderecosUsuario> findEnderecoUsuarioById(@Param("cpfCnpj") Long cpfCnpj, @Param("codigoCadastroEndereco") Long codigoCadastroEndereco);

}
