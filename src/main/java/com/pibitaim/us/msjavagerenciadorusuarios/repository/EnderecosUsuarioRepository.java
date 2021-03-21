package com.pibitaim.us.msjavagerenciadorusuarios.repository;

import com.pibitaim.us.msjavagerenciadorusuarios.entity.EnderecosUsuario;
import com.pibitaim.us.msjavagerenciadorusuarios.entity.EnderecosUsuarioId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface EnderecosUsuarioRepository extends JpaRepository<EnderecosUsuario, EnderecosUsuarioId> {

    @Query(value = "SELECT * FROM TBUS005_END_USU " +
            "WHERE CPF_CNPJ = :cpfCnpj" +
            "  AND COD_CAD_END = :codigoCadastroEndereco", nativeQuery = true)
    Optional<EnderecosUsuario> findEnderecoUsuarioById(@Param("cpfCnpj") Long cpfCnpj, @Param("codigoCadastroEndereco") Long codigoCadastroEndereco);

    @Query(value = "SELECT COUNT (*) FROM TBUS005_END_USU " +
            "WHERE CPF_CNPJ = :cpfCnpjUsuario", nativeQuery = true)
    Integer qtdEnderecosPorCpfCnpj(@Param("cpfCnpjUsuario") Long cpfCnpjUsuario);

    @Query(value = "SELECT NIV_PRIO FROM TBUS005_END_USU " +
            "WHERE CPF_CNPJ = :cpfCnpjUsuario " +
            "ORDER BY NIV_PRIO DESC LIMIT 1", nativeQuery = true)
    Integer getUltimoNivelPrioridade(@Param("cpfCnpjUsuario") Long cpfCnpjUsuario);

    @Query(value = "SELECT * FROM TBUS005_END_USU " +
            "WHERE CPF_CNPJ = :cpfCnpjUsuario", nativeQuery = true)
    Optional<List<EnderecosUsuario>> existeEnderecosCadastradosParaCpfCnpj(@Param("cpfCnpjUsuario") Long cpfCnpjUsuario);

    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE TBUS005_END_USU " +
            "SET END_PRI = FALSE " +
            "WHERE CPF_CNPJ = :cpfCnpjUsuario " +
            "  AND END_PRI = TRUE", nativeQuery = true)
    void atualizaEnderecosPrincipais(@Param("cpfCnpjUsuario") Long cpfCnpjUsuario);
}
