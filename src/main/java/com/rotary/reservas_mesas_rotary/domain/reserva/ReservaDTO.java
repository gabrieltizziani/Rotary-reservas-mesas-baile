package com.rotary.reservas_mesas_rotary.domain.reserva;

import java.time.LocalDateTime;

public record ReservaDTO(
        Long id,
        String nomeParaReserva,
        LocalDateTime dataReserva,
        boolean ativa
) {
    public ReservaDTO(Reserva reserva) {
        this(
                reserva.getId(),
                reserva.getNomeParaReserva(),
                reserva.getDataReserva(),
                reserva.isAtiva()
        );
    }
}
