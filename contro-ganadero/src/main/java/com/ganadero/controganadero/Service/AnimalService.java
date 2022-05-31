package com.ganadero.controganadero.Service;

import java.util.List;

import com.ganadero.controganadero.dto.AnimalDTO;
import com.ganadero.controganadero.dto.NuevoAnimalDTO;



public interface AnimalService {
    public AnimalDTO create (NuevoAnimalDTO animalDTO);
    public AnimalDTO retrieve(Long id) throws Exception;
    public AnimalDTO update(AnimalDTO animalDTO,Long id) throws Exception;
    public void delete (Long id ) throws Exception;

    public List<AnimalDTO> list();
}
