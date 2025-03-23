package com.pokeapi.trainers.dto;

import lombok.Data;

import java.util.List;

@Data
public class PokemonDTO {
    private Long id;
    private String nombre;
    private List<String> tipos;
    private Integer nivel;
    private PokemonStatisticsDTO estadisticas;
    private List<String> movimientos;
    private String sprite;
}
