package com.ganadero.controganadero.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CuidadorDTO extends NuevoCuidadorDTO{
    private long id;
    private String nombre;
    private String apellido;
    private String cedula;
    private String email;
    private String telefono;
}
