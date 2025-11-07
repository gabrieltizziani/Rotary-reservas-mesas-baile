package com.rotary.reservas_mesas_rotary.domain.mesa;

import com.rotary.reservas_mesas_rotary.domain.reserva.ReservaDTO;

public record MesaDTO(
        Long id,
        Integer numeroMesa,
        boolean reservada,
        Long reservaId,
        ReservaDTO reservaDTO
) {
    public MesaDTO(Mesa mesa) {
        this(
                mesa.getId(),
                mesa.getNumeroMesa(),
                mesa.isReservada(),
                mesa.getReserva() != null ? mesa.getReserva().getId() : null,
                (mesa.getReserva() != null && mesa.getReserva().isAtiva())
                        ? new ReservaDTO(mesa.getReserva())
                        : null
        );
    }
}
