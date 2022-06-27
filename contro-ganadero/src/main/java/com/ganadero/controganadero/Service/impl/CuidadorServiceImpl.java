package com.ganadero.controganadero.Service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ganadero.controganadero.Service.CuidadorService;
import com.ganadero.controganadero.dto.CuidadorDTO;
import com.ganadero.controganadero.dto.NuevoCuidadorDTO;
import com.ganadero.controganadero.exception.ResourceNotFoundException;
import com.ganadero.controganadero.models.cuidador;
import com.ganadero.controganadero.repositories.CuidadorRepository;

@Service
public class CuidadorServiceImpl implements CuidadorService{

    final ModelMapper   modelMapper;
    final CuidadorRepository cuidadorRepository;
    
    public CuidadorServiceImpl(@Autowired CuidadorRepository repository, ModelMapper mapper){
        this.cuidadorRepository = repository;
        this.modelMapper = mapper;
    }

    @Override
    @Transactional
    public CuidadorDTO create(NuevoCuidadorDTO cuidadorDTO) {
        cuidador cuidador = modelMapper.map(cuidadorDTO, cuidador.class);
        cuidadorRepository.save(cuidador);
        return modelMapper.map(cuidador, CuidadorDTO.class);
        
    }

    @Override
    @Transactional (readOnly = true)
    public CuidadorDTO retrieve(Long id) throws Exception {
        cuidador cuidador = cuidadorRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Cuidador not found"));
        return modelMapper.map(cuidador, CuidadorDTO.class);
    }

    @Override
    @Transactional
    public CuidadorDTO update(CuidadorDTO cuidadorDTO, Long id) throws Exception {
        cuidador cuidador = cuidadorRepository.findById(id)
        .orElseThrow(()-> new ResourceNotFoundException("Cuidador not found"));
        cuidador.setId(id);
        cuidador = modelMapper.map(cuidadorDTO, cuidador.class);
        cuidadorRepository.save(cuidador);

        return modelMapper.map(cuidador, CuidadorDTO.class);
    }

    @Override
    @Transactional
    public void delete(Long id) throws Exception {
        cuidador cuidador = cuidadorRepository.findById(id)
        .orElseThrow(()-> new ResourceNotFoundException("Cuidador not found"));        
        cuidadorRepository.deleteById(cuidador.getId()); 
        
    }

    @Override
    public List<CuidadorDTO> list() {
        List<cuidador> cuidadores= cuidadorRepository.findAll();
        return cuidadores.stream().map(cuidador -> modelMapper.map(cuidador, CuidadorDTO.class))
            .collect(Collectors.toList());   
    }

    
}
