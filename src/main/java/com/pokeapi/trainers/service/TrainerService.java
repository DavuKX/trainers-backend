package com.pokeapi.trainers.service;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pokeapi.trainers.dto.TrainerRequestDTO;
import com.pokeapi.trainers.dto.TrainerResponseDTO;
import com.pokeapi.trainers.exception.EmailAlreadyExistsException;
import com.pokeapi.trainers.exception.ResourceNotFoundException;
import com.pokeapi.trainers.mapper.TrainerMapper;
import com.pokeapi.trainers.model.Trainer;
import com.pokeapi.trainers.repository.TrainerRepository;

@Service
public class TrainerService implements ITrainerService {
    private final TrainerRepository trainerRepository;
    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

    public TrainerService(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    @Override
    public TrainerResponseDTO create(TrainerRequestDTO trainerRequestDTO) {
        if (trainerRepository.findByEmail(trainerRequestDTO.getEmail()).isPresent()) {
            throw new EmailAlreadyExistsException("El email ya está en uso");
        }

        try {
            Trainer trainer = TrainerMapper.requestToEntity(trainerRequestDTO);
            return TrainerMapper.entityToResponse(trainerRepository.save(trainer));
        } catch (Exception e) {
            throw new RuntimeException("Error parsing date");
        }
    }

    @Override
    public TrainerResponseDTO findById(Long id) {
        Trainer trainer = trainerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id.toString(), "Trainer"));
        return TrainerMapper.entityToResponse(trainer);
    }

    @Override
    public TrainerResponseDTO update(Long id, TrainerRequestDTO trainerRequestDTO) {
        Trainer trainer = trainerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id.toString(), "Trainer"));

        trainer.setFirstName(trainerRequestDTO.getFirstName());
        trainer.setLastName(trainerRequestDTO.getLastName());
        trainer.setEmail(trainerRequestDTO.getEmail());
        trainer.setPassword(trainerRequestDTO.getPassword());

        try {
            trainer.setBirthDate(formatter.parse(trainerRequestDTO.getBirthDate()));
        } catch (Exception e) {
            throw new RuntimeException("Error parsing date");
        }

        return TrainerMapper.entityToResponse(trainerRepository.save(trainer));
    }

    @Override
    public void delete(Long id) {
        Trainer trainer = trainerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id.toString(), "Trainer"));
        trainerRepository.delete(trainer);
    }

    @Override
    public TrainerResponseDTO findByEmail(String email) {
        Trainer trainer = trainerRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException(email, "Trainer"));
        return TrainerMapper.entityToResponse(trainer);
    }

    @Override
    public List<TrainerResponseDTO> findAll() {
        List<Trainer> trainers = trainerRepository.findAll();

        return trainers.stream()
                .map(TrainerMapper::entityToResponse)
                .toList();
    }
}
