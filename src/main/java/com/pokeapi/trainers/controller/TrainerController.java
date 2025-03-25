package com.pokeapi.trainers.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pokeapi.trainers.dto.TrainerRequestDTO;
import com.pokeapi.trainers.dto.TrainerResponseDTO;
import com.pokeapi.trainers.service.ITrainerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/trainers")
public class TrainerController {
    private final ITrainerService trainerService;

    public TrainerController(ITrainerService trainerService) {
        this.trainerService = trainerService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrainerResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(trainerService.findById(id));
    }
    
    @GetMapping
    public ResponseEntity<List<TrainerResponseDTO>> findAll() {
        return ResponseEntity.ok(trainerService.findAll());
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

    @GetMapping("/email/{email}")
    public ResponseEntity<TrainerResponseDTO> findByEmail(@PathVariable String email) {
        return ResponseEntity.ok(trainerService.findByEmail(email));
    }
}