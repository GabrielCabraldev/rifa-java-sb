package com.rifa.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class RifaDTO {
    private Long id;
    private String titulo;
    private BigDecimal precoBilhete;
    private LocalDate dataInicio;
    private LocalDate dataTermino;
}
