package com.ganadero.controganadero.Service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ganadero.controganadero.Service.CarneService;
import com.ganadero.controganadero.dto.CarneDTO;
import com.ganadero.controganadero.dto.NuevaCarneDTO;
import com.ganadero.controganadero.exception.ResourceNotFoundException;
import com.ganadero.controganadero.models.Carne;
import com.ganadero.controganadero.repositories.CarjeRepository;

@Service
public class CarneServiceImpl implements CarneService {
    
    final ModelMapper   modelMapper;
    final CarjeRepository carjeRepository ;
    
    public CarneServiceImpl(@Autowired CarjeRepository repository, ModelMapper mapper){
        this.carjeRepository = repository;
        this.modelMapper = mapper;
    }
    


    @Override
    @Transactional
    public CarneDTO create(NuevaCarneDTO carneDTIO) {
        Carne carne = modelMapper.map(carneDTIO, Carne.class);
            carjeRepository.save(carne);
            return modelMapper.map(carne, CarneDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public CarneDTO retrieve(Long id)  throws Exception {
        Carne carne = carjeRepository.findById(id)
        .orElseThrow(()-> new ResourceNotFoundException("Carne not found"));
return modelMapper.map(carne, CarneDTO.class);
    }

    @Override
    @Transactional
    public CarneDTO update(CarneDTO carneDTIO, Long id) throws Exception {
        Carne carne = carjeRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Carne not found"));
        carne.setId(id);
        carne = modelMapper.map(carneDTIO, Carne.class);
        carjeRepository.save(carne);

        return modelMapper.map(carne, CarneDTO.class);
    }

    @Override
    @Transactional
    public void delete(Long id) throws Exception {
        Carne carne = carjeRepository.findById(id)
        .orElseThrow(()-> new ResourceNotFoundException("Animal not found"));        
        carjeRepository.deleteById(carne.getId());    
        
    }

    @Override
    @Transactional(readOnly = true)
    public List<CarneDTO> list() {
        List<Carne> carnes= carjeRepository.findAll();
        return carnes.stream().map(carne -> modelMapper.map(carne, CarneDTO.class))
            .collect(Collectors.toList()); 
    }
    
}
