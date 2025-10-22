package com.rotary.reservas_mesas_rotary.domain.mesa;

import com.rotary.reservas_mesas_rotary.domain.baile.Baile;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "mesa")
@Table(name = "mesa")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Mesa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Integer numeroMesa;

    private boolean reservada = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "baile_id", nullable = false)
    private Baile baile;
}
