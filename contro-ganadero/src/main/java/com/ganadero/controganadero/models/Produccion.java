package com.ganadero.controganadero.models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;



@MappedSuperclass
public abstract class Produccion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "FECHA_PRODUCCION")
    private String fecha_produccion;

    public void setId(Long id2) {
    }

    public Long getId() {
        return null;
    }
    

}
