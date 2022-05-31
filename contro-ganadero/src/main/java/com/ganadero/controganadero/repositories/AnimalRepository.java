package com.ganadero.controganadero.repositories;

import java.util.List;

import com.ganadero.controganadero.models.Animal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  AnimalRepository extends JpaRepository<Animal,Long>{
    
    public List<Animal> findByNombre(String criteria);
}
