package com.ganadero.controganadero.Service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ganadero.controganadero.Service.LecheService;
import com.ganadero.controganadero.dto.LecheDTO;
import com.ganadero.controganadero.dto.NuevaLecheDTO;
import com.ganadero.controganadero.exception.ResourceNotFoundException;
import com.ganadero.controganadero.models.Leche;
import com.ganadero.controganadero.repositories.LecheRepositoru;

@Service
public class LecheServiceImpl  implements LecheService{

    final ModelMapper   modelMapper;
    final LecheRepositoru lecheRepositoru;
    
    public LecheServiceImpl(@Autowired LecheRepositoru repository, ModelMapper mapper){
        this.lecheRepositoru = repository;
        this.modelMapper = mapper;
    }
    
    @Override
     @Transactional
    public LecheDTO create(NuevaLecheDTO lecheDTO) {
        Leche leche = modelMapper.map(lecheDTO, Leche.class);
        lecheRepositoru.save(leche);
        return modelMapper.map(leche, LecheDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public LecheDTO retrieve(Long id) throws Exception {
        Leche leche = lecheRepositoru.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Leche not found"));
        return modelMapper.map(leche, LecheDTO.class);
    }

    @Override
    @Transactional
    public LecheDTO update(LecheDTO lecheDTO, Long id) throws Exception {
        Leche leche = lecheRepositoru.findById(id)
        .orElseThrow(()-> new ResourceNotFoundException("Leche not found"));
        leche.setId(id);
        leche = modelMapper.map(lecheDTO, Leche.class);
        lecheRepositoru.save(leche);

        return modelMapper.map(leche, LecheDTO.class);
    }

    @Override
    @Transactional
    public void delete(Long id) throws Exception {
        Leche leche = lecheRepositoru.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Leche not found"));        
        lecheRepositoru.deleteById(leche.getId());  
        
    }

    @Override
    @Transactional(readOnly = true)
    public List<LecheDTO> list() {
        List<Leche> animals= lecheRepositoru.findAll();
        return animals.stream().map(animal -> modelMapper.map(animal, LecheDTO.class))
            .collect(Collectors.toList());     
    }
    
}
