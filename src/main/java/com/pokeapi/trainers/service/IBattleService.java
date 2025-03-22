package com.pokeapi.trainers.service;

import com.pokeapi.trainers.dto.BattleDTO;

import java.util.List;

public interface IBattleService {
    List<BattleDTO> getBattles(Long trainerId);
}
