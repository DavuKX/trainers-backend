package com.pokeapi.trainers.service;

import com.pokeapi.trainers.dto.TeamDTO;

import java.util.List;

public interface ITeamService {
    List<TeamDTO> getTeams(Long trainerId);
}
