package com.pokeapi.trainers.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<TrainerResponseDTO> login(@RequestBody LoginRequestDTO loginRequestDTO) {
        return ResponseEntity.ok(authService.login(loginRequestDTO));
    }
}
