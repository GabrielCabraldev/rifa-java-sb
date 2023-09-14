package com.rifa.controller.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class RifaDTO {
    private Long id;
    private String nome;
    private BigDecimal precoBilhete;
    private LocalDate dataInicio;
    private LocalDate dataTermino;
}
