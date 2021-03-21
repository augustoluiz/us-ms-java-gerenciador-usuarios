package com.pibitaim.us.msjavagerenciadorusuarios.repository;

import com.pibitaim.us.msjavagerenciadorusuarios.entity.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByCpfCnpj(Long cpfCnpj);

    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE TBUS001_CAD_UNI_USU SET " +
            "CPF_CNPJ = :cpfCnpj, " +
            "DAT_BAT = :dataBatismo, " +
            "DAT_NSC = :dataNascimento, " +
            "DAT_ULT_ATU = CURRENT_TIMESTAMP, " +
            "EST_CIV = :estadoCivil, " +
            "SEX_USU = :sexoUsuario, " +
            "TIP_PES = :tipoPessoa, " +
            "IND_MEM = :indicadorMembresia, " +
            "NOM_USU = :nomeUsuario " +
            "WHERE CPF_CNPJ = :cpfCnpjOriginal", nativeQuery = true)
    void update(@Param("cpfCnpj") Long cpfCnpj,
                   @Param("dataBatismo") Date dataBatismo,
                   @Param("dataNascimento") Date dataNascimento,
                   @Param("estadoCivil") String estadoCivil,
                   @Param("sexoUsuario") String sexoUsuario,
                   @Param("tipoPessoa") String tipoPessoa,
                   @Param("indicadorMembresia") Boolean indicadorMembresia,
                   @Param("nomeUsuario") String nomeUsuario,
                   @Param("cpfCnpjOriginal") Long cpfCnpjOriginal);

    void deleteByCpfCnpj(Long cpfCnpj);

    @Query(value = "SELECT * FROM TBUS001_CAD_UNI_USU " +
            "WHERE CPF_CNPJ = :cpfCnpj " +
            "  AND SEN_ACE_USU = :senhaAtual", nativeQuery = true)
    Optional<Usuario> findByCpfCnpj(@Param("cpfCnpj") Long cpfCnpj, @Param("senhaAtual") String senhaAtual);

    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE TBUS001_CAD_UNI_USU " +
            "SET SEN_ACE_USU = :novaSenha," +
            "    DAT_ULT_ATU = :dataUltimaAtualizacao " +
            "WHERE CPF_CNPJ = :cpfCnpj", nativeQuery = true)
    void updateSenha(@Param("cpfCnpj") Long cpfCnpj, @Param("novaSenha") String novaSenha, @Param("dataUltimaAtualizacao") Date dataUltimaAtualizacao);

    @Query(value = "SELECT * FROM TBUS001_CAD_UNI_USU USU " +
            "INNER JOIN TBUS005_END_USU END " +
            "ON (USU.CPF_CNPJ = END.CPF_CNPJ) " +
            "WHERE END.COD_CAD_END = :enderecoId", nativeQuery = true)
    Page<Usuario> findByEnderecoId(Pageable paginacao, @Param("enderecoId") Long enderecoId);

}
