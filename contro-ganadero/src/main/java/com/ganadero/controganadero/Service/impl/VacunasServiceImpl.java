package com.ganadero.controganadero.Service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ganadero.controganadero.Service.VacunaService;
import com.ganadero.controganadero.dto.NuevoVacunaDTO;
import com.ganadero.controganadero.dto.VacunaDTO;
import com.ganadero.controganadero.exception.ResourceNotFoundException;
import com.ganadero.controganadero.models.Vacuna;
import com.ganadero.controganadero.repositories.VacunaRepository;

@Service
public class VacunasServiceImpl implements VacunaService{

    final ModelMapper   modelMapper;
    final VacunaRepository vacunaRepository;
    
    public VacunasServiceImpl(@Autowired VacunaRepository repository, ModelMapper mapper){
        this.vacunaRepository = repository;
        this.modelMapper = mapper;
    }
    
    @Override
    @Transactional
    public VacunaDTO create(NuevoVacunaDTO vacunaDTO) {
        Vacuna vacuna = modelMapper.map(vacunaDTO, Vacuna.class);
        vacunaRepository.save(vacuna);
        return modelMapper.map(vacuna, VacunaDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public VacunaDTO retrieve(Long id) throws Exception {
        Vacuna vacuna = vacunaRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Vacuna not found"));
        return modelMapper.map(vacuna, VacunaDTO.class);
    }

    @Override
    @Transactional
    public VacunaDTO update(VacunaDTO vacunaDTO, Long id) throws Exception {
        Vacuna vacuna = vacunaRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Vacuna not found"));
        vacuna.setId(id);
        vacuna = modelMapper.map(vacunaDTO, Vacuna.class);
        vacunaRepository.save(vacuna);

        return modelMapper.map(vacuna, VacunaDTO.class);
    }

    @Override
    @Transactional
    public void delete(Long id) throws Exception {
        Vacuna vacuna = vacunaRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Vacuna not found"));        
        vacunaRepository.deleteById(vacuna.getId());        
        
    }

    @Override
    @Transactional(readOnly = true)
    public List<VacunaDTO> list() {
        List<Vacuna> vacunas= vacunaRepository.findAll();
        return vacunas.stream().map(vacuna -> modelMapper.map(vacuna, VacunaDTO.class))
            .collect(Collectors.toList());  
    }

    
}
