package com.pokeapi.trainers.controller;

import com.pokeapi.trainers.dto.TrainerRequestDTO;
import com.pokeapi.trainers.dto.TrainerResponseDTO;
import com.pokeapi.trainers.service.ITrainerService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api/trainers")
public class TrainerController {
    private final ITrainerService trainerService;

    public TrainerController(ITrainerService trainerService) {
        this.trainerService = trainerService;
    }

    @PostMapping()
    public ResponseEntity<TrainerResponseDTO> create(@Valid @RequestBody TrainerRequestDTO trainerRequestDTO) {
        return ResponseEntity.ok(trainerService.create(trainerRequestDTO));
    }
}
