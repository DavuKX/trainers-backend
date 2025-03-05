package com.pokeapi.trainers.mapper;

import com.pokeapi.trainers.dto.TrainerRequestDTO;
import com.pokeapi.trainers.dto.TrainerResponseDTO;
import com.pokeapi.trainers.model.Trainer;

public class TrainerMapper {
    public static Trainer requestToEntity(TrainerRequestDTO trainerRequestDTO) {
        Trainer trainer = new Trainer();
        trainer.setFirstName(trainerRequestDTO.getFirstName());
        trainer.setLastName(trainerRequestDTO.getLastName());
        trainer.setEmail(trainerRequestDTO.getEmail());
        trainer.setPassword(trainerRequestDTO.getPassword());
        return trainer;
    }

    public static TrainerResponseDTO entityToResponse(Trainer trainer) {
        TrainerResponseDTO trainerResponseDTO = new TrainerResponseDTO();
        trainerResponseDTO.setId(trainer.getId());
        trainerResponseDTO.setFirstName(trainer.getFirstName());
        trainerResponseDTO.setLastName(trainer.getLastName());
        trainerResponseDTO.setEmail(trainer.getEmail());
        trainerResponseDTO.setPassword(trainer.getPassword());
        return trainerResponseDTO;
    }
}
