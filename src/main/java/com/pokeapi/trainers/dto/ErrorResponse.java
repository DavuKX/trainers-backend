package com.pokeapi.trainers.dto;

import lombok.Data;

import java.util.List;

@Data
public class ErrorResponse {
    private String message;
    private List<String> errors;
}
