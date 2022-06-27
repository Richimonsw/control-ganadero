package com.ganadero.controganadero.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LecheDTO extends NuevaLecheDTO {
    private Long id;
    private String litro;
}
