package com.pokeapi.trainers.dto;

import lombok.Data;

import java.util.List;

@Data
public class TeamTrainerResponseDTO {
    private Long id;
    private Long entrenadorId;
    private List<Long> equiposIds;
    private Long equipoSeleccionado;
}
