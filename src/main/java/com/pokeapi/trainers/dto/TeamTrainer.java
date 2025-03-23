package com.pokeapi.trainers.dto;

import lombok.Data;

import java.util.List;

@Data
public class TeamTrainer {
    private Long id;
    private Long entrenadorId;
    private List<Long> equiposIds;
    private Long equipoSeleccionado;
}
