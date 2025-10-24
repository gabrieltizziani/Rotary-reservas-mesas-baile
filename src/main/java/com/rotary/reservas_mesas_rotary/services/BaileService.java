package com.rotary.reservas_mesas_rotary.services;

import com.rotary.reservas_mesas_rotary.domain.baile.*;
import com.rotary.reservas_mesas_rotary.domain.mesa.Mesa;
import com.rotary.reservas_mesas_rotary.repositories.BaileRepository;
import com.rotary.reservas_mesas_rotary.repositories.MesaRepositoy;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class BaileService {

    @Autowired
    private BaileRepository baileRepository;
    @Autowired
    private MesaRepositoy mesaRepositoy;

    @Transactional
    public Baile cadastroBaile(DadosCadastroBaile dadosCadastroBaile){
        if (dadosCadastroBaile.dataDoBaile().isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("A data do baile não pode ser no passado.");
        }
        if (dadosCadastroBaile.totalMesas() <= 0) {
            throw new IllegalArgumentException("O total de mesas deve ser maior que zero.");
        }

        var baile = new Baile(dadosCadastroBaile);
        baileRepository.save(baile);

        gerarMesasAutomaticamente(baile, dadosCadastroBaile.totalMesas());

        return baile;
    }

    public List<DadosListagemBaile> listarBailes() {
        var bailes =  baileRepository.findAll();

        bailes.forEach(this::verificarStatusAutomatico);

        return bailes.stream()
                .map(DadosListagemBaile::new)
                .toList();
    }

    public Baile atualizarBaile(DadosAtualizarBaile dadosAtualizarBaile){
        if (dadosAtualizarBaile.totalMesas() != null && dadosAtualizarBaile.totalMesas() <= 0) {
            throw new IllegalArgumentException("O total de mesas deve ser maior que zero.");
        }

        var baile = baileRepository.getReferenceById(dadosAtualizarBaile.id());
        baile.atualizarBaile(dadosAtualizarBaile);
        return baileRepository.save(baile);
    }

    public void excluirBaile(Long id){
        if(!baileRepository.existsById(id)){
            throw new EntityNotFoundException("Baile com o ID " + id + " não encontrado.");
        }
        baileRepository.deleteById(id);
    }

    public void verificarStatusAutomatico(Baile baile){
        if (baile.getDataDoBaile().isBefore(LocalDateTime.now())
                &&baile.getStatus() == StatusBaile.ABERTO) {
            baile.setStatus(StatusBaile.ENCERRADO);
            baileRepository.save(baile);
        }
    }

    private void gerarMesasAutomaticamente(Baile baile, Integer totalMesas){
        List<Mesa> mesas = new ArrayList<>();
        for (int i = 1; i <= totalMesas; i++){
            Mesa mesa = new Mesa();
            mesa.setNumeroMesa(i);
            mesa.setReservada(false);
            mesa.setBaile(baile);
            mesas.add(mesa);
        }
        mesaRepositoy.saveAll(mesas);
    }

    public BaileComMesasDTO listarBaileComMesas(Long idBaile){
        var baile = baileRepository.getReferenceById(idBaile);
        return new BaileComMesasDTO(baile);
    }

}
