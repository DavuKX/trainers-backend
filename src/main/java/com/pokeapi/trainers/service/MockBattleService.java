package com.pokeapi.trainers.service;

import com.pokeapi.trainers.dto.BattleDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MockBattleService implements IBattleService {
    @Override
    public List<BattleDTO> getBattles(Long trainerId) {
        return List.of(
        );
    }
}
