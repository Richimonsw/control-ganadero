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
@Table(name="TBL_USUARIO")
@Getter 
@Setter
public class Usuario {
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
    @Column(name = "CONTRASEÑA")
    private String contras;

    @OneToMany(mappedBy = "usuario")
    private List<Animal> animal;
}
