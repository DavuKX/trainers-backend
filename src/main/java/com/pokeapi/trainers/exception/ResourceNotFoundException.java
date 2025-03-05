package com.pokeapi.trainers.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String id, String resource) {
        super(String.format("%s with id %s not found", resource, id));
    }
}
