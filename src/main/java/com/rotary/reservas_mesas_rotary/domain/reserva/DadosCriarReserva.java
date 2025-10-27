package com.rotary.reservas_mesas_rotary.domain.reserva;

import jakarta.validation.constraints.NotBlank;

public record DadosCriarReserva(
        Long baileId,
        Integer numeroMesa,

        @NotBlank(message = "O nome para a reserva é obrigatório")
        String nomeParaReserva
) {
}
