package com.pokeapi.trainers.dto;

import lombok.Data;

@Data
public class TrainerResponseDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String birthDate;
}
