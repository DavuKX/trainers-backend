package com.pokeapi.trainers.dto;

import lombok.Data;

import java.util.List;

@Data
public class TeamResponseDTO {
    private Long id;
    private String nombre;
    private List<Long> pokemonIds;
}
