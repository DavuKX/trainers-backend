package com.pokeapi.trainers.dto;

import lombok.Data;
import java.util.List;

@Data
public class ErrorResponse {
    private String message;
    private List<String> errors;

    public ErrorResponse() {}

    public ErrorResponse(String message, List<String> errors) {
        this.message = message;
        this.errors = errors;
    }

}