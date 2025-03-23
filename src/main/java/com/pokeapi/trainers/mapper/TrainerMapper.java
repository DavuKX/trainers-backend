package com.pokeapi.trainers.mapper;

import com.pokeapi.trainers.dto.TrainerRequestDTO;
import com.pokeapi.trainers.dto.TrainerResponseDTO;
import com.pokeapi.trainers.model.Trainer;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TrainerMapper {
    static SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
    public static Trainer requestToEntity(TrainerRequestDTO trainerRequestDTO) throws ParseException {
        Trainer trainer = new Trainer();
        trainer.setFirstName(trainerRequestDTO.getFirstName());
        trainer.setLastName(trainerRequestDTO.getLastName());
        trainer.setEmail(trainerRequestDTO.getEmail());
        trainer.setPassword(trainerRequestDTO.getPassword());
        trainer.setBirthDate(trainerRequestDTO.getBirthDate() != null ? formatter.parse(trainerRequestDTO.getBirthDate()) : null);
        return trainer;
    }

    public static TrainerResponseDTO entityToResponse(Trainer trainer) {
        TrainerResponseDTO trainerResponseDTO = new TrainerResponseDTO();
        trainerResponseDTO.setId(trainer.getId());
        trainerResponseDTO.setFirstName(trainer.getFirstName());
        trainerResponseDTO.setLastName(trainer.getLastName());
        trainerResponseDTO.setEmail(trainer.getEmail());
        trainerResponseDTO.setBirthDate(trainer.getBirthDate() != null ? formatter.format(trainer.getBirthDate()) : null);
        return trainerResponseDTO;
    }
}
