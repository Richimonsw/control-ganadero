package com.ganadero.controganadero.repositories;

import com.ganadero.controganadero.models.Carne;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarjeRepository extends JpaRepository<Carne,Long> {
    
}
