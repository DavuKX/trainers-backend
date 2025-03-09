package com.pokeapi.trainers.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.pokeapi.trainers.dto.LoginRequestDTO;
import com.pokeapi.trainers.dto.TrainerResponseDTO;
import com.pokeapi.trainers.exception.InvalidCredentialsException;
import com.pokeapi.trainers.mapper.TrainerMapper;
import com.pokeapi.trainers.model.Trainer;
import com.pokeapi.trainers.repository.TrainerRepository;

@Service
public class AuthService implements IAuthService {
  private final TrainerRepository trainerRepository;

  AuthService(TrainerRepository trainerRepository) {
    this.trainerRepository = trainerRepository;
  }

  @Override
  public TrainerResponseDTO login(LoginRequestDTO dto) {
    Optional<Trainer> trainer = trainerRepository.findByEmail(dto.getEmail());

    if (trainer.isEmpty() || !trainer.get().getPassword().equals(dto.getPassword())) {
      throw new InvalidCredentialsException();
    }

    return TrainerMapper.entityToResponse(trainer.get());
  }
}
