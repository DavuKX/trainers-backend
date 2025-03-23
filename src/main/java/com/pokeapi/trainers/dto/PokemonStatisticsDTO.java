package com.pokeapi.trainers.dto;

import lombok.Data;

@Data
public class PokemonStatisticsDTO {
    private Integer hp;
    private Integer ataque;
    private Integer defensa;
    private Integer ataqueEspecial;
    private Integer defensaEspecial;
    private Integer velocidad;
}
