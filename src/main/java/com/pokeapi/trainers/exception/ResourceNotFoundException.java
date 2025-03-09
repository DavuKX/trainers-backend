package com.pokeapi.trainers.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String id, String resource) {
        super(String.format("El recurso %s con id %s no ha sido encontrado", resource, id));
    }
}
