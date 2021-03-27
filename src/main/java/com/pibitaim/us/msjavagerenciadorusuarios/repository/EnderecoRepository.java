package com.pibitaim.us.msjavagerenciadorusuarios.repository;

import com.pibitaim.us.msjavagerenciadorusuarios.entity.Endereco;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

    @Query(value = "SELECT * FROM TBUS004_CAD_END_USU END " +
            "INNER JOIN TBUS005_END_USU ENU " +
            "ON (END.COD_CAD_END = ENU.COD_CAD_END) " +
            "INNER JOIN TBUS001_CAD_UNI_USU USU " +
            "ON (ENU.COD_IDE_USU = USU.COD_IDE_USU) " +
            "WHERE USU.CPF_CNPJ = :usuarioCpfCnpj", nativeQuery = true)
    Page<Endereco> findByUsuarioId(Pageable paginacao, @Param("usuarioCpfCnpj") Long usuarioCpfCnpj);

    @Modifying(clearAutomatically = true)
    @Query(value = "DELETE * FROM TBUS004_CAD_END_USU " +
            "WHERE COD_CAD_END = :id", nativeQuery = true)
    void deleteById(@Param("id") Long id);

}



