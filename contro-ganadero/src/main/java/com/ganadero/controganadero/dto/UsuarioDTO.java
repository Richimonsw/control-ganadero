package com.ganadero.controganadero.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO extends NuevoUsuarioDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private String cedula;
    private String email;
    private String contras;
}
