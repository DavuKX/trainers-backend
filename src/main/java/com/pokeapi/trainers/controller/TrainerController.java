package com.pokeapi.trainers.controller;

import com.pokeapi.trainers.dto.TrainerRequestDTO;
import com.pokeapi.trainers.dto.TrainerResponseDTO;
import com.pokeapi.trainers.service.IBattleService;
import com.pokeapi.trainers.service.ITeamService;
import com.pokeapi.trainers.service.ITrainerService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/trainers")
public class TrainerController {
    private final ITrainerService trainerService;

    public TrainerController(ITrainerService trainerService, ITeamService teamService, IBattleService battleService) {
        this.trainerService = trainerService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrainerResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(trainerService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TrainerResponseDTO> update(@PathVariable Long id, @Valid @RequestBody TrainerRequestDTO trainerRequestDTO) {
        return ResponseEntity.ok(trainerService.update(id, trainerRequestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        trainerService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{email}")
    public ResponseEntity<TrainerResponseDTO> findByEmail(@PathVariable String email) {
        return ResponseEntity.ok(trainerService.findByEmail(email));
    }
}