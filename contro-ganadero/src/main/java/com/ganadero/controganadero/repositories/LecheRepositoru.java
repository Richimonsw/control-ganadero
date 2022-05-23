package com.ganadero.controganadero.repositories;

import com.ganadero.controganadero.models.Leche;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LecheRepositoru extends JpaRepository<Leche,Long>  {
    
}
