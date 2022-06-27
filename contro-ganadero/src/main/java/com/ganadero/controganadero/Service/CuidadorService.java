package com.ganadero.controganadero.Service;

import java.util.List;

import com.ganadero.controganadero.dto.CuidadorDTO;
import com.ganadero.controganadero.dto.NuevoCuidadorDTO;

public interface CuidadorService {
    public CuidadorDTO create (NuevoCuidadorDTO cuidadorDTO);
    public CuidadorDTO retrieve(Long id) throws Exception;
    public CuidadorDTO update(CuidadorDTO cuidadorDTO,Long id) throws Exception;
    public void delete (Long id ) throws Exception;

    public List<CuidadorDTO> list();
    
}
