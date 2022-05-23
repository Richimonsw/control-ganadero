package com.ganadero.controganadero.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="TBL_CUIDADOR")
@Getter 
@Setter
public class cuidador {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "APELLIDO")
    private String apellido;
    @Column(name = "CEDULA")
    private String cedula;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "TELEFONO")
    private String telefono;

    @OneToMany(mappedBy = "cuidador")
    private List<Animal> animal;

}
