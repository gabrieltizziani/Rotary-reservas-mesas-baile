package com.rotary.reservas_mesas_rotary.domain.baile;

import com.rotary.reservas_mesas_rotary.domain.mesa.MesaDTO;

import java.time.LocalDateTime;
import java.util.List;

public record BaileComMesasDTO(
        Long id,
        String nomeBaile,
        String descricaoBaile,
        LocalDateTime dataDoBaile,
        String localizacao,
        Integer totalMesas,
        List<MesaDTO> mesas
) {
    public BaileComMesasDTO(Baile baile) {
        this(
                baile.getId(),
                baile.getNomeBaile(),
                baile.getDescricaoBaile(),
                baile.getDataDoBaile(),
                baile.getLocalizacao(),
                baile.getTotalMesas(),
                baile.getMesas().stream().map(MesaDTO::new).toList()
        );
    }
}

