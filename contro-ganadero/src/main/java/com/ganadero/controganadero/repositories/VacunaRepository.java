package com.ganadero.controganadero.repositories;

import com.ganadero.controganadero.models.Vacuna;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface VacunaRepository extends JpaRepository<Vacuna,Long>{
    
}
