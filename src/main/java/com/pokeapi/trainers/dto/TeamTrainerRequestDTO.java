package com.pokeapi.trainers.dto;

import lombok.Data;

import java.util.List;

@Data
public class TeamTrainerRequestDTO {
    private Long entrenadorId;
    private List<Long> equiposIds;
    private String equipoSeleccionado;
}
