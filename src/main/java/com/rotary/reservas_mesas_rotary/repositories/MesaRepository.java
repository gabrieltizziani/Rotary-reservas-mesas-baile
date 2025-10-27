package com.rotary.reservas_mesas_rotary.repositories;

import com.rotary.reservas_mesas_rotary.domain.mesa.Mesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MesaRepository extends JpaRepository<Mesa, Integer> {
    Optional<Mesa> findByBaileIdAndNumeroMesa(Long baileId, Integer numeroMesa);

    List<Mesa> findAllByBaileId(Long baileId);
}
