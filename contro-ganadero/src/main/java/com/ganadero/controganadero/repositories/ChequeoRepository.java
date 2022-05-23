package com.ganadero.controganadero.repositories;

import com.ganadero.controganadero.models.Chequeo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ChequeoRepository extends JpaRepository<Chequeo,Long>  {
    
}
