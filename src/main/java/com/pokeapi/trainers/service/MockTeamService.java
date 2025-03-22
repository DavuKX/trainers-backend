package com.pokeapi.trainers.service;

import com.pokeapi.trainers.dto.TeamDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MockTeamService implements ITeamService {
    @Override
    public List<TeamDTO> getTeams(Long trainerId) {
        return List.of();
    }
}
