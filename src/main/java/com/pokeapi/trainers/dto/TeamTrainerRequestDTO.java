package com.pokeapi.trainers.dto;

import lombok.Data;

import java.util.List;

@Data
public class TeamTrainerRequestDTO {
    private String entrenadorId;
    private List<Long> equiposIds;
    private String equipoSeleccionado;
}
