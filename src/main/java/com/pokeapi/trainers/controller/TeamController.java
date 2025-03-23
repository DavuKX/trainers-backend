package com.pokeapi.trainers.controller;

import com.pokeapi.trainers.dto.TeamRequestDTO;
import com.pokeapi.trainers.dto.TeamResponseDTO;
import com.pokeapi.trainers.dto.TeamUpdateRequestDTO;
import com.pokeapi.trainers.service.ITeamService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/teams")
public class TeamController {
    private final ITeamService teamService;

    public TeamController(ITeamService teamService) {
        this.teamService = teamService;
    }

    @PostMapping()
    public ResponseEntity<TeamResponseDTO> create(@RequestBody TeamRequestDTO dto) {
        return ResponseEntity.ok(teamService.create(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeamResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(teamService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TeamResponseDTO> update(@PathVariable Long id, @RequestBody TeamUpdateRequestDTO dto) {
        return ResponseEntity.ok(teamService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        teamService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
