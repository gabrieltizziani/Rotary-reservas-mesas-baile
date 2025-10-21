package com.rotary.reservas_mesas_rotary.domain.baile;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosAtualizarBaile(
    @NotNull
    Long id,

    String nomeBaile,
    String descricaoBaile,
    LocalDateTime dataDoBaile,
    String localizacao,
    StatusBaile status
) {
}
