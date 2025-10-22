package com.rotary.reservas_mesas_rotary.domain.baile;

import com.rotary.reservas_mesas_rotary.domain.mesa.Mesa;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "baile")
@Table(name = "baile")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Baile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeBaile;
    private String descricaoBaile;
    private LocalDateTime dataDoBaile;
    private String localizacao;
    private Integer totalMesas;

    @OneToMany(mappedBy = "baile", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Mesa> mesas = new ArrayList<>();


    @Enumerated(EnumType.STRING)
    private StatusBaile status =  StatusBaile.ABERTO;

    public Baile (DadosCadastroBaile dadosCadastroBaile){
        this.nomeBaile = dadosCadastroBaile.nomeBaile();
        this.descricaoBaile = dadosCadastroBaile.descricaoBaile();
        this.dataDoBaile = dadosCadastroBaile.dataDoBaile();
        this.localizacao = dadosCadastroBaile.localizacao();
        this.totalMesas = dadosCadastroBaile.totalMesas();
    }

    public void atualizarBaile (DadosAtualizarBaile dadosAtualizarBaile){
        if (dadosAtualizarBaile.nomeBaile() != null){
            this.nomeBaile = dadosAtualizarBaile.nomeBaile();
        }
        if (dadosAtualizarBaile.descricaoBaile() != null){
            this.descricaoBaile = dadosAtualizarBaile.descricaoBaile();
        }
        if (dadosAtualizarBaile.dataDoBaile() != null){
            this.dataDoBaile = dadosAtualizarBaile.dataDoBaile();
        }
        if (dadosAtualizarBaile.localizacao() != null){
            this.localizacao = dadosAtualizarBaile.localizacao();
        }
        if (dadosAtualizarBaile.totalMesas() != null){
            this.totalMesas = dadosAtualizarBaile.totalMesas();
        }
        if (dadosAtualizarBaile.status() != null){
            this.status = dadosAtualizarBaile.status();
        }
    }
}
