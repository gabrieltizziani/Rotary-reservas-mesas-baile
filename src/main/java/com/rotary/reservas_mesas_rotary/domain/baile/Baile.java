package com.rotary.reservas_mesas_rotary.domain.baile;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

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
    private StatusBaile status =  StatusBaile.ABERTO;

    public Baile (DadosCadastroBaile dadosCadastroBaile){
        this.nomeBaile = dadosCadastroBaile.nomeBaile();
        this.descricaoBaile = dadosCadastroBaile.descricaoBaile();
        this.dataDoBaile = dadosCadastroBaile.dataDoBaile();
        this.localizacao = dadosCadastroBaile.localizacao();
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
        if (dadosAtualizarBaile.status() != null){
            this.status = dadosAtualizarBaile.status();
        }
    }







}
