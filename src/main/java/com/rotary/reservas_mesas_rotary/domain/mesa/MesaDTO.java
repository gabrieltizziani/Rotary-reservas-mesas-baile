package com.rotary.reservas_mesas_rotary.domain.mesa;

import com.rotary.reservas_mesas_rotary.domain.mesa.Mesa;
import com.rotary.reservas_mesas_rotary.domain.reserva.Reserva;
import com.rotary.reservas_mesas_rotary.domain.reserva.ReservaDTO;

public record MesaDTO(
        Long id,
        Integer numeroMesa,
        boolean reservada,
        ReservaDTO reservaDTO
) {
    public MesaDTO(Mesa mesa) {
        this(
                (long) mesa.getId(),
                mesa.getNumeroMesa(),
                mesa.isReservada(),
                (mesa.getReserva() != null && mesa.getReserva().isAtiva())
                        ? new ReservaDTO(mesa.getReserva())
                        : null
        );
    }

}

