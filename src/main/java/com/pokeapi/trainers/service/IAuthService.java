package com.pokeapi.trainers.service;

import com.pokeapi.trainers.dto.LoginRequestDTO;
import com.pokeapi.trainers.dto.TrainerResponseDTO;

public interface IAuthService {
    TrainerResponseDTO login(LoginRequestDTO dto);
}
