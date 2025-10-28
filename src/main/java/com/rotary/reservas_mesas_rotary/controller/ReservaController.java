package com.rotary.reservas_mesas_rotary.controller;

import com.rotary.reservas_mesas_rotary.domain.reserva.DadosCriarReserva;
import com.rotary.reservas_mesas_rotary.domain.reserva.Reserva;
import com.rotary.reservas_mesas_rotary.domain.reserva.ReservaDTO;
import com.rotary.reservas_mesas_rotary.services.ReservaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @PostMapping
    public ResponseEntity<ReservaDTO> criarReservas(@RequestBody @Valid DadosCriarReserva dadosCriarReserva){
        Reserva reserva = reservaService.criarReserva(dadosCriarReserva);
        return ResponseEntity.ok(new ReservaDTO(reserva));
    }

    @DeleteMapping("/{id}/cancelar")
    public ResponseEntity<Void> cancelarReserva(@PathVariable("id") long id) {
        reservaService.cancelarReserva(id);
        return ResponseEntity.ok().build(); 
    }
}
