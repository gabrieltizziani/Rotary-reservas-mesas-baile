package com.rotary.reservas_mesas_rotary.domain.baile;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosCadastroBaile(
        @NotBlank(message = "O nome do baile é obrigatório")
        String nomeBaile,

        @NotBlank(message = "A descrição do baile é obrigatória")
        String descricaoBaile,

        @NotNull(message = "A data do baile é obrigatória")
        @FutureOrPresent(message = "A data do baile deve ser no presente ou futuro.")
        LocalDateTime dataDoBaile,

        @NotBlank(message = "A localização do baile é obrigatória ")
        String localizacao

) {
}
