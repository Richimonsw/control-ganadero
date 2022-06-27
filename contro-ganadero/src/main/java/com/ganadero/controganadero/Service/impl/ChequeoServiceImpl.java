package com.ganadero.controganadero.Service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ganadero.controganadero.Service.ChequeoService;
import com.ganadero.controganadero.dto.ChequeoDTO;
import com.ganadero.controganadero.dto.NuevoChequeoDTO;
import com.ganadero.controganadero.exception.ResourceNotFoundException;
import com.ganadero.controganadero.models.Chequeo;
import com.ganadero.controganadero.repositories.ChequeoRepository;

@Service
public class ChequeoServiceImpl implements ChequeoService{
    
    final ModelMapper   modelMapper;
    final ChequeoRepository chequeoRepository;
    
    public ChequeoServiceImpl(@Autowired ChequeoRepository repository, ModelMapper mapper){
        this.chequeoRepository = repository;
        this.modelMapper = mapper;
    }


    @Override
    @Transactional
    public ChequeoDTO create(NuevoChequeoDTO chequeoDTO) {
        Chequeo chequeo = modelMapper.map(chequeoDTO, Chequeo.class);
        chequeoRepository.save(chequeo);
        return modelMapper.map(chequeo, ChequeoDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public ChequeoDTO retrieve(Long id) throws Exception {
        Chequeo chequeo = chequeoRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Chqueo not found"));
        return modelMapper.map(chequeo, ChequeoDTO.class);
    }

    @Override
    @Transactional
    public ChequeoDTO update(ChequeoDTO chequeoDTO, Long id) throws Exception {
        Chequeo chequeo = chequeoRepository.findById(id)
        .orElseThrow(()-> new ResourceNotFoundException("Chequeo not found"));
        chequeo.setId(id);
        chequeo = modelMapper.map(chequeoDTO, Chequeo.class);
        chequeoRepository.save(chequeo);

        return modelMapper.map(chequeo, ChequeoDTO.class);

    }

    @Override
    @Transactional
    public void delete(Long id) throws Exception {
        Chequeo chequeo = chequeoRepository.findById(id)
        .orElseThrow(()-> new ResourceNotFoundException("Chequeo not found"));        
        chequeoRepository.deleteById(chequeo.getId());      
        
    }

    @Override
    public List<ChequeoDTO> list() {
        List<Chequeo> chequeos= chequeoRepository.findAll();
        return chequeos.stream().map(chequeo -> modelMapper.map(chequeo, ChequeoDTO.class))
            .collect(Collectors.toList());     
    }
    
}
