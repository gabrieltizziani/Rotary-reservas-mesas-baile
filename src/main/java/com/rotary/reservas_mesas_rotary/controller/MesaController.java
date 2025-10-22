package com.rotary.reservas_mesas_rotary.controller;

import com.rotary.reservas_mesas_rotary.domain.mesa.Mesa;
import com.rotary.reservas_mesas_rotary.repositories.MesaRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mesas")
public class MesaController {

    @Autowired
    MesaRepositoy mesaRepositoy;

    @GetMapping("/baile/{baileId}")
    public ResponseEntity <List<Mesa>> listarMesasPorBaile(@PathVariable Long baileId){
        List<Mesa> mesas = mesaRepositoy.findByBaileId(baileId);
        if(mesas.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(mesas);
    }
}
