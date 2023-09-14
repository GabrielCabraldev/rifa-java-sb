package com.rifa.model;


import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@Entity
@Table(name = "rifas")
@Data
public class Rifa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "preco")
    private double precoBilhete;

    @Column(name = "dataInicio")
    private LocalDate dataInicio;

    @Column(name = "dataTermino")
    private LocalDate dataTermino;
    @Column(name = "quantidade_total")
    private int quantidadeTotal;

    @Column(name = "quantidade_vendida")
    private int quantidadeVendida;

    public int getQuantidadeDisponivel() {
        return quantidadeTotal - quantidadeVendida;
    }
}
