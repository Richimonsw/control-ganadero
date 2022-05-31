package com.ganadero.controganadero.Service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.ganadero.controganadero.Service.AnimalService;
import com.ganadero.controganadero.dto.AnimalDTO;
import com.ganadero.controganadero.dto.NuevoAnimalDTO;
import com.ganadero.controganadero.exception.ResourceNotFoundException;
import com.ganadero.controganadero.models.Animal;
import com.ganadero.controganadero.repositories.AnimalRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AnimalServiceImpl  implements AnimalService{
    
    final ModelMapper   modelMapper;
    final AnimalRepository animalRepository;
    
    public AnimalServiceImpl(@Autowired AnimalRepository repository, ModelMapper mapper){
        this.animalRepository = repository;
        this.modelMapper = mapper;
    }

    @Override
    @Transactional
    public AnimalDTO create(NuevoAnimalDTO animalDTO) {
        Animal animal = modelMapper.map(animalDTO, Animal.class);
        animalRepository.save(animal);
        return modelMapper.map(animal, AnimalDTO.class);
        
    }

    @Override
    @Transactional(readOnly = true)
    public AnimalDTO retrieve(Long id) throws Exception {
        Animal animal = animalRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Animal not found"));
        return modelMapper.map(animal, AnimalDTO.class);
    }

    @Override
    @Transactional
    public AnimalDTO update(AnimalDTO animalDTO, Long id) throws Exception {
        Animal animal = animalRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Animal not found"));
        animal.setId(id);
        animal = modelMapper.map(animalDTO, Animal.class);
        animalRepository.save(animal);

        return modelMapper.map(animal, AnimalDTO.class);
    }

    @Override
    @Transactional
    public void delete(Long id) throws Exception {
        Animal animal = animalRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Animal not found"));        
        animalRepository.deleteById(animal.getId());        
    }
    @Override
    @Transactional(readOnly = true)
    public List<AnimalDTO> list() {
        List<Animal> animals= animalRepository.findAll();
        return animals.stream().map(animal -> modelMapper.map(animal, AnimalDTO.class))
            .collect(Collectors.toList());        
    }
    
    
}
