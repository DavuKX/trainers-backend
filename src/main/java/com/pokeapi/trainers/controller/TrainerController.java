package com.pokeapi.trainers.controller;

import com.pokeapi.trainers.dto.TrainerRequestDTO;
import com.pokeapi.trainers.dto.TrainerResponseDTO;
import com.pokeapi.trainers.service.ITrainerService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ResponseEntity<TrainerResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(trainerService.findById(id));
    }
}
