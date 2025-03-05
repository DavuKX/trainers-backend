package com.pokeapi.trainers.service;

import com.pokeapi.trainers.dto.TrainerRequestDTO;
import com.pokeapi.trainers.dto.TrainerResponseDTO;
import com.pokeapi.trainers.exception.EmailAlreadyExistsException;
import com.pokeapi.trainers.exception.ResourceNotFoundException;
import com.pokeapi.trainers.mapper.TrainerMapper;
import com.pokeapi.trainers.model.Trainer;
import com.pokeapi.trainers.repository.TrainerRepository;
import org.springframework.stereotype.Service;

@Service
public class TrainerService implements ITrainerService {
    private final TrainerRepository trainerRepository;

    public TrainerService(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    @Override
    public TrainerResponseDTO create(TrainerRequestDTO trainerRequestDTO) {
        if (trainerRepository.findByEmail(trainerRequestDTO.getEmail()) != null) {
            throw new EmailAlreadyExistsException("Email already exists");
        }

        return TrainerMapper.entityToResponse(trainerRepository.save(TrainerMapper.requestToEntity(trainerRequestDTO)));
    }

    @Override
    public TrainerResponseDTO findById(Long id) {
        Trainer trainer = trainerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id.toString(), "Trainer"));

        return TrainerMapper.entityToResponse(trainer);
    }
}
