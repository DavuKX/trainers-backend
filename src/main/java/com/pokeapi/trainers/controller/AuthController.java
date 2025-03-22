package com.pokeapi.trainers.controller;

import com.pokeapi.trainers.dto.JwtResponse;
import com.pokeapi.trainers.dto.TrainerRequestDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pokeapi.trainers.dto.LoginRequestDTO;
import com.pokeapi.trainers.dto.TrainerResponseDTO;
import com.pokeapi.trainers.service.IAuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final IAuthService authService;

    AuthController(IAuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody LoginRequestDTO loginRequestDTO) {
        return ResponseEntity.ok(authService.login(loginRequestDTO.getEmail(), loginRequestDTO.getPassword()));
    }

    @PostMapping("/register")
    public ResponseEntity<TrainerResponseDTO> create(@Valid @RequestBody TrainerRequestDTO trainerRequestDTO) {
        TrainerResponseDTO response = authService.register(
                trainerRequestDTO.getFirstName(),
                trainerRequestDTO.getLastName(),
                trainerRequestDTO.getEmail(),
                trainerRequestDTO.getPassword(),
                trainerRequestDTO.getBirthDate()
        );
        return ResponseEntity.ok(response);
    }
}
