package com.rotary.reservas_mesas_rotary.repositories;

import com.rotary.reservas_mesas_rotary.domain.baile.Baile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BaileRepository extends JpaRepository<Baile, Long> {

    @Query("""
        SELECT b FROM baile b
        ORDER BY 
            CASE 
                WHEN b.status = 'ATIVO' THEN 1
                WHEN b.status IN ('ENCERRADO', 'CANCELADO') THEN 2
                ELSE 3
            END,
            FUNCTION('DATEDIFF', b.dataDoBaile, CURRENT_DATE) ASC
    """)
    Page<Baile> findBailesOrdenados(Pageable pageable);
}
