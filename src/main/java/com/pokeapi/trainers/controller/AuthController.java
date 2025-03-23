package com.pokeapi.trainers.controller;

import com.pokeapi.trainers.dto.*;
import com.pokeapi.trainers.service.PasswordResetService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pokeapi.trainers.service.IAuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final IAuthService authService;
    private final PasswordResetService passwordResetService;

    AuthController(IAuthService authService, PasswordResetService passwordResetService) {
        this.authService = authService;
        this.passwordResetService = passwordResetService;
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

    @GetMapping("/me")
    public ResponseEntity<TrainerResponseDTO> me() {
        return ResponseEntity.ok(authService.me());
    }

    @PostMapping("/forgot-password")
    public ResponseEntity<String> forgotPassword(@RequestBody ForgotPasswordDTO dto) {
        passwordResetService.sendResetToken(dto.getEmail());
        return ResponseEntity.ok("Password reset link has been sent to your email");
    }

    @PostMapping("/reset-password")
    public ResponseEntity<String> resetPassword(@RequestBody ResetPasswordDTO dto) {
        passwordResetService.resetPassword(dto.getToken(), dto.getNewPassword());
        return ResponseEntity.ok("Password has been reset");
    }
}
