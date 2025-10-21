package com.rotary.reservas_mesas_rotary.controller;

import com.rotary.reservas_mesas_rotary.domain.baile.Baile;
import com.rotary.reservas_mesas_rotary.domain.baile.DadosCadastroBaile;
import com.rotary.reservas_mesas_rotary.domain.baile.DadosListagemBaile;
import com.rotary.reservas_mesas_rotary.repositories.BaileRepository;
import com.rotary.reservas_mesas_rotary.services.BaileService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/baile")
public class BaileController {

    @Autowired
    private BaileService baileService;

    @PostMapping
    public ResponseEntity cadastroBaile(@RequestBody @Valid DadosCadastroBaile dadosCadastroBaile){
        baileService.cadastroBaile(dadosCadastroBaile);
        return ResponseEntity.ok(dadosCadastroBaile);
    }

    @GetMapping
    public ResponseEntity <List<DadosListagemBaile>> listarBailes(){
        var bailes = baileService.listarBailes();
        return ResponseEntity.ok(bailes);
    }

}
