package com.rotary.reservas_mesas_rotary.repositories;

import com.rotary.reservas_mesas_rotary.domain.mesa.Mesa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MesaRepositoy extends JpaRepository<Mesa, Integer> {
    List<Mesa> findByBaileId(Long baileId);
}
