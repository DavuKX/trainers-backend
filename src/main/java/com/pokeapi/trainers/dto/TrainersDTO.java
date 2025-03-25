package com.pokeapi.trainers.dto;

import java.util.List;

import lombok.Data;

@Data
public class TrainersDTO {
    private List<TrainerResponseDTO> trainers;
}
