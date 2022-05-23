package com.ganadero.controganadero.repositories;

import com.ganadero.controganadero.models.Produccion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UsuarioRepository extends JpaRepository<Produccion,Long> {
    
}
