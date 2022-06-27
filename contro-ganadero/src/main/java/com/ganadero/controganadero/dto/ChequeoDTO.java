package com.ganadero.controganadero.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChequeoDTO extends NuevoChequeoDTO{
    private long id;
    private String nombreVet;
    private String fechaCheq;
    private String observacion;
}
