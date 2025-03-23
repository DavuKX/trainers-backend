package com.pokeapi.trainers.service;

import com.pokeapi.trainers.dto.TeamDTO;
import com.pokeapi.trainers.dto.TeamRequestDTO;
import com.pokeapi.trainers.dto.TeamResponseDTO;
import com.pokeapi.trainers.dto.TeamUpdateRequestDTO;

import java.util.List;

public interface ITeamService {
    TeamResponseDTO create(TeamRequestDTO dto);
    TeamResponseDTO findById(Long id);
    TeamResponseDTO update(Long id, TeamUpdateRequestDTO dto);
    void delete(Long id);
}
