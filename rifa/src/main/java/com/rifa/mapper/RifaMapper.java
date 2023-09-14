package com.rifa.mapper;

import com.rifa.dto.RifaDTO;
import com.rifa.model.Rifa;
import org.springframework.stereotype.Component;

@Component
public class RifaMapper {
    public RifaDTO toDTO(Rifa rifa) {
        RifaDTO rifaDTO = new RifaDTO();
        rifaDTO.setId(rifa.getId());
        rifaDTO.setTitulo(rifa.getTitulo());
        rifaDTO.setPrecoBilhete(rifa.getPrecoBilhete());
        rifaDTO.setDataInicio(rifa.getDataInicio());
        rifaDTO.setDataTermino(rifa.getDataTermino());
        return rifaDTO;
    }
}