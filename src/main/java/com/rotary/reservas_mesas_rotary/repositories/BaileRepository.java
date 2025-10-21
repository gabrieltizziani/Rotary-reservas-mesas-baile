package com.rotary.reservas_mesas_rotary.repositories;

import com.rotary.reservas_mesas_rotary.domain.baile.Baile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaileRepository extends JpaRepository<Baile,Long> {
}
