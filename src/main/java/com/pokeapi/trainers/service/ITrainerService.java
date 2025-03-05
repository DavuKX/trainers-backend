package com.pokeapi.trainers.service;

import com.pokeapi.trainers.dto.TrainerRequestDTO;
import com.pokeapi.trainers.dto.TrainerResponseDTO;

public interface ITrainerService {
    TrainerResponseDTO create(TrainerRequestDTO trainerRequestDTO);

    TrainerResponseDTO findById(Long id);
}
