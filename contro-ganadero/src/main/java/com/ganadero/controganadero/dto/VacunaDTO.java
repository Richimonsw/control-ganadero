package com.ganadero.controganadero.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VacunaDTO extends NuevoVacunaDTO{
    private Long id;
    private String nombreVet;
    private String fechaVac;
    private String observacion;

}
