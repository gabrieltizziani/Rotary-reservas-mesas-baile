package com.rotary.reservas_mesas_rotary.domain.baile;

import java.time.LocalDateTime;

public record DadosListagemBaile(Long id, String nomeBaile, String descricaoBaile, LocalDateTime dataDoBaile, String localizacao, Integer totalMesas, StatusBaile status) {
    public DadosListagemBaile(Baile baile) {
        this(baile.getId(), baile.getNomeBaile(), baile.getDescricaoBaile(), baile.getDataDoBaile(), baile.getLocalizacao(), baile.getTotalMesas(), baile.getStatus());
    }
}
