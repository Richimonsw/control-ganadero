package com.ganadero.controganadero.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="TBL_ANIMALES")
@Getter 
@Setter
public class Vacuna {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "NOMBRE_VACUNA")
    private String nombreVet;
    @Column(name = "FECHA_VACUNA")
    private String fechaVac;
    @Column(name = "OBSERVACIONES")
    private String observacion;

    @ManyToOne
    @JoinColumn(name="ANIMAL_ID", nullable = false)
    private Animal animal;
}
