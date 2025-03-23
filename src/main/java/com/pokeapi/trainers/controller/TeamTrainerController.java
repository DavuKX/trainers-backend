package com.pokeapi.trainers.controller;

import com.pokeapi.trainers.dto.TeamTrainerRequestDTO;
import com.pokeapi.trainers.dto.TeamTrainerResponseDTO;
import com.pokeapi.trainers.service.ITeamTrainerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/team-trainers")
public class TeamTrainerController {
    private final ITeamTrainerService teamTrainerService;

    public TeamTrainerController(ITeamTrainerService teamTrainerService) {
        this.teamTrainerService = teamTrainerService;
    }

    @PostMapping
    public ResponseEntity<TeamTrainerResponseDTO> createTeamTrainer(@RequestBody TeamTrainerRequestDTO dto) {
        return ResponseEntity.ok(teamTrainerService.createTeamTrainer(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeamTrainerResponseDTO> getTeamTrainer(@PathVariable Long id) {
        return ResponseEntity.ok(teamTrainerService.getTeamTrainer(id));
    }

    @GetMapping("/trainer/{trainerId}")
    public ResponseEntity<TeamTrainerResponseDTO> getTeamTrainerByTrainerId(@PathVariable Long trainerId) {
        return ResponseEntity.ok(teamTrainerService.getTeamTrainerByTrainerId(trainerId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TeamTrainerResponseDTO> updateTeamTrainer(@PathVariable Long id, @RequestBody TeamTrainerRequestDTO dto) {
        return ResponseEntity.ok(teamTrainerService.updateTeamTrainer(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeamTrainer(@PathVariable Long id) {
        teamTrainerService.deleteTeamTrainer(id);
        return ResponseEntity.noContent().build();
    }
}
