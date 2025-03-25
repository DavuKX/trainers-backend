package com.pokeapi.trainers.service;

import java.util.List;

import com.pokeapi.trainers.dto.TrainerRequestDTO;
import com.pokeapi.trainers.dto.TrainerResponseDTO;

public interface ITrainerService {
    List<TrainerResponseDTO> findAll();
    TrainerResponseDTO create(TrainerRequestDTO trainerRequestDTO);
    TrainerResponseDTO findById(Long id);
    TrainerResponseDTO update(Long id, TrainerRequestDTO trainerRequestDTO);
    void delete(Long id);
    TrainerResponseDTO findByEmail(String email);
}
