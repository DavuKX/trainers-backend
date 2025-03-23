package com.pokeapi.trainers.dto;

public record JwtResponse(String token, String type, String email, Long userId) {
}
