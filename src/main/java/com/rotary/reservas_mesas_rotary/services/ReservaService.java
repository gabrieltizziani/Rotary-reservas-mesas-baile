package com.rotary.reservas_mesas_rotary.services;

import com.rotary.reservas_mesas_rotary.domain.baile.Baile;
import com.rotary.reservas_mesas_rotary.domain.baile.StatusBaile;
import com.rotary.reservas_mesas_rotary.domain.mesa.Mesa;
import com.rotary.reservas_mesas_rotary.domain.reserva.DadosCriarReserva;
import com.rotary.reservas_mesas_rotary.domain.reserva.Reserva;
import com.rotary.reservas_mesas_rotary.repositories.BaileRepository;
import com.rotary.reservas_mesas_rotary.repositories.MesaRepository;
import com.rotary.reservas_mesas_rotary.repositories.ReservaRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservaService {
    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private BaileRepository baileRepository;

    @Autowired
    private MesaRepository mesaRepository;

    @Transactional
    public Reserva criarReserva(DadosCriarReserva dados) {
        Baile baile = baileRepository.findById(dados.baileId())
                .orElseThrow(() -> new EntityNotFoundException("Baile não encontrado."));

        if (baile.getStatus() == StatusBaile.ENCERRADO) {
            throw new IllegalStateException("Não é possível reservar mesas para um baile encerrado.");
        }

        Mesa mesa = mesaRepository.findByBaileIdAndNumeroMesa(dados.baileId(), dados.numeroMesa())
                .orElseThrow(() -> new EntityNotFoundException("Mesa não encontrada para o baile informado."));

        if (mesa.isReservada()) {
            throw new IllegalStateException("Essa mesa já está reservada!");
        }

        mesa.setReservada(true);
        mesaRepository.save(mesa);

        Reserva reserva = new Reserva(dados, mesa, baile);
        return reservaRepository.save(reserva);
    }

    @Transactional
    public void cancelarReserva(Long reservaId) {
        Reserva reserva = reservaRepository.findById(reservaId)
                .orElseThrow(() -> new EntityNotFoundException("Reserva não encontrada."));

        reserva.setAtiva(false);
        reserva.getMesa().setReservada(false);

        mesaRepository.save(reserva.getMesa());
        reservaRepository.save(reserva);
    }


}
