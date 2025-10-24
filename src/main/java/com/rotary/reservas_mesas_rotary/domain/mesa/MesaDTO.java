package com.rotary.reservas_mesas_rotary.domain.mesa;

public record MesaDTO(
        Long id,
        Integer numeroMesa,
        boolean reservada
) {
    public MesaDTO (Mesa mesa){
        this((long) mesa.getId(), mesa.getNumeroMesa(), mesa.isReservada());
    }
}
