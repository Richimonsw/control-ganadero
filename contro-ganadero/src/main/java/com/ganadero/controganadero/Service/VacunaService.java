package com.ganadero.controganadero.Service;

import java.util.List;

import com.ganadero.controganadero.dto.NuevoVacunaDTO;
import com.ganadero.controganadero.dto.VacunaDTO;

public interface VacunaService {
    
    public VacunaDTO create (NuevoVacunaDTO vacunaDTO);
    public VacunaDTO retrieve(Long id) throws Exception;
    public VacunaDTO update(VacunaDTO vacunaDTO,Long id) throws Exception;
    public void delete (Long id ) throws Exception;

    public List<VacunaDTO> list();
}
