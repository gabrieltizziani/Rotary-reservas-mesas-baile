package com.rotary.reservas_mesas_rotary.domain.reserva;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.rotary.reservas_mesas_rotary.domain.baile.Baile;
import com.rotary.reservas_mesas_rotary.domain.mesa.Mesa;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity(name = "reserva")
@Table(name = "reserva")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(of = "id")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeParaReserva;
    private LocalDateTime dataReserva =  LocalDateTime.now();

    @OneToOne
    @JoinColumn(name = "mesa_id", nullable = false)
    @JsonBackReference
    private Mesa mesa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "baile_id", nullable = false)
    @JsonBackReference
    private Baile baile;

    private boolean ativa = true;


    public Reserva(DadosCriarReserva dadosCriarReserva, Mesa mesa, Baile baile){
        this.nomeParaReserva = dadosCriarReserva.nomeParaReserva();
        this.mesa = mesa;
        this.baile = baile;
        this.dataReserva = LocalDateTime.now();
        this.ativa = true;
    }


}
