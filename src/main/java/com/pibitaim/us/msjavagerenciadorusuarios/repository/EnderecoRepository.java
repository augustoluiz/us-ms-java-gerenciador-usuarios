package com.pibitaim.us.msjavagerenciadorusuarios.repository;

import com.pibitaim.us.msjavagerenciadorusuarios.entity.Endereco;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

    @Query(value = "SELECT * FROM TBUS004_CAD_END_USU END " +
            "INNER JOIN TBUS005_END_USU ENU " +
            "ON (END.COD_CAD_END = ENU.COD_CAD_END) " +
            "WHERE ENU.CPF_CNPJ = :usuarioCpfCnpj", nativeQuery = true)
    Page<Endereco> findByUsuarioId(Pageable paginacao, @Param("usuarioCpfCnpj") Long usuarioCpfCnpj);

}



