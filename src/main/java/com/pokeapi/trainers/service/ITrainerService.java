package com.pokeapi.trainers.service;

import com.pokeapi.trainers.dto.TrainerRequestDTO;
import com.pokeapi.trainers.dto.TrainerResponseDTO;
import com.pokeapi.trainers.dto.TrainersDTO;

public interface ITrainerService {
    TrainersDTO findAll();
    TrainerResponseDTO create(TrainerRequestDTO trainerRequestDTO);
    TrainerResponseDTO findById(Long id);
    TrainerResponseDTO update(Long id, TrainerRequestDTO trainerRequestDTO);
    void delete(Long id);
    TrainerResponseDTO findByEmail(String email);
}
