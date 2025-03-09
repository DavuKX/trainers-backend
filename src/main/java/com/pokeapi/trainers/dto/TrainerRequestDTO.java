package com.pokeapi.trainers.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;

@Data
public class TrainerRequestDTO {
    @NotBlank
    @Size(min = 3, max = 20, message = "Primer nombre debe tener entre 3 y 20 caracteres")
    private String firstName;

    @NotBlank
    @Size(min = 3, max = 20, message = "Apellido debe tener entre 3 y 20 caracteres")
    private String lastName;

    @NotBlank
    @Email(message = "Email debe ser válido")
    private String email;

    @NotBlank
    @Size(min = 8, max = 20, message = "Contraseña debe tener entre 8 y 20 caracteres")
    private String password;

    private Date birthDate;
}
