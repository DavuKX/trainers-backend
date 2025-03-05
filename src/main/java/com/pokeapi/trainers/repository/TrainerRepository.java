package com.pokeapi.trainers.repository;

import com.pokeapi.trainers.model.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainerRepository extends JpaRepository<Trainer, Long> {
    Trainer findByEmail(String email);
}
