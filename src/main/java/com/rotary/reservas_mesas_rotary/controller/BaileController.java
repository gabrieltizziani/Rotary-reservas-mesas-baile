package com.rotary.reservas_mesas_rotary.controller;

import com.rotary.reservas_mesas_rotary.domain.baile.*;
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

    @PutMapping
    public ResponseEntity atualizarBaile(@RequestBody @Valid DadosAtualizarBaile dadosAtualizarBaile){
        var baileAtualizado = baileService.atualizarBaile(dadosAtualizarBaile);
        return ResponseEntity.ok(new DadosListagemBaile(baileAtualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirBaile(@PathVariable long id){
        baileService.excluirBaile(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/mesas")
    public ResponseEntity<BaileComMesasDTO> listarMesas(@PathVariable long id){
        var baileComMesas = baileService.listarBaileComMesas(id);
        return ResponseEntity.ok(baileComMesas);
    }



}
