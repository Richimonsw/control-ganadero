package com.ganadero.controganadero.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarneDTO extends NuevaCarneDTO{
    private Long id;
    private String peso;
}
