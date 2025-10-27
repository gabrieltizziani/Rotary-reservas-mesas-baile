package com.rotary.reservas_mesas_rotary.repositories;

import com.rotary.reservas_mesas_rotary.domain.reserva.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
}
