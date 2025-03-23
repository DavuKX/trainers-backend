package com.pokeapi.trainers.dto;

import lombok.Data;

import java.util.List;

@Data
public class TeamRequestDTO {
    private String entrenadorId;
    private String nombre;
    private List<Long> pokemonIds;
}
