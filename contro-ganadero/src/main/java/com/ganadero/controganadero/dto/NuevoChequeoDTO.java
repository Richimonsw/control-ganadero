package com.ganadero.controganadero.dto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NuevoChequeoDTO {
    private String nombreVet;
    private String fechaCheq;
    private String observacion;
}
