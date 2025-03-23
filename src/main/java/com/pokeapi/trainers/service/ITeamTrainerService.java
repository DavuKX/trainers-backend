package com.pokeapi.trainers.service;

import com.pokeapi.trainers.dto.TeamTrainerRequestDTO;
import com.pokeapi.trainers.dto.TeamTrainerResponseDTO;

public interface ITeamTrainerService {
    TeamTrainerResponseDTO createTeamTrainer(TeamTrainerRequestDTO dto);
    TeamTrainerResponseDTO getTeamTrainer(Long id);
    TeamTrainerResponseDTO getTeamTrainerByTrainerId(Long trainerId);
    TeamTrainerResponseDTO updateTeamTrainer(Long id, TeamTrainerRequestDTO dto);
    void deleteTeamTrainer(Long id);
}
