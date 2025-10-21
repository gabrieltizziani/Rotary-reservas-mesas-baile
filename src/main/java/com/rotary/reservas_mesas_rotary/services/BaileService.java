package com.rotary.reservas_mesas_rotary.services;

import com.rotary.reservas_mesas_rotary.domain.baile.Baile;
import com.rotary.reservas_mesas_rotary.domain.baile.DadosCadastroBaile;
import com.rotary.reservas_mesas_rotary.domain.baile.DadosListagemBaile;
import com.rotary.reservas_mesas_rotary.repositories.BaileRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BaileService {

    @Autowired
    private BaileRepository baileRepository;

    @Transactional
    public Baile cadastroBaile(DadosCadastroBaile dadosCadastroBaile){
        if (dadosCadastroBaile.dataDoBaile().isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("A data do baile não pode ser no passado.");
        }

        var baile = new Baile(dadosCadastroBaile);
        baileRepository.save(baile);

        return baile;
    }

    public List<DadosListagemBaile> listarBailes() {
        return baileRepository.findAll()
                .stream()
                .map(DadosListagemBaile::new)
                .toList();
    }

}
