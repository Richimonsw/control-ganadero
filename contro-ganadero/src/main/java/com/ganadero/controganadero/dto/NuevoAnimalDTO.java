package com.ganadero.controganadero.dto;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NuevoAnimalDTO {
    @NotNull(message = "Nombre width can't be null")
    private String nombre;
    @NotNull(message = "Fecha width can't be null")
    private String fechaNac;
    private String raza;
    private String propocito;
    
}
