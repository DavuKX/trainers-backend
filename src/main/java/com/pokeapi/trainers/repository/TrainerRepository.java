package com.pokeapi.trainers.repository;

import com.pokeapi.trainers.model.Trainer;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainerRepository extends JpaRepository<Trainer, Long> {
    Optional<Trainer> findByEmail(String email);
}
