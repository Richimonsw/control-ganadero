package com.ganadero.controganadero.dto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NuevoUsuarioDTO {
    private String nombre;
    private String apellido;
    private String cedula;
    private String email;
    private String contras;
}
