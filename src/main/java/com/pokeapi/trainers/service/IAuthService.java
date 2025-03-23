package com.pokeapi.trainers.service;

import com.pokeapi.trainers.dto.JwtResponse;
import com.pokeapi.trainers.dto.TrainerResponseDTO;

public interface IAuthService {
    JwtResponse login(String email, String password);
    TrainerResponseDTO register(String firstName, String lastName, String email, String password, String birthDate);
    TrainerResponseDTO me();
}
