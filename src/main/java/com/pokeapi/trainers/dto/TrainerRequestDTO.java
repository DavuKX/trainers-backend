package com.pokeapi.trainers.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

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

    @Pattern(regexp = "^(0?[1-9]|[1|2][0-9]|3[0|1])-(0?[1-9]|1[0-2])-([0-9]{4}|[0-9]{2})$", message = "Fecha de nacimiento debe tener el formato dd-MM-yyyy")
    private String birthDate;
}
