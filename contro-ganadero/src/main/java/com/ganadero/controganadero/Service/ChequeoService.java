package com.ganadero.controganadero.Service;

import java.util.List;

import com.ganadero.controganadero.dto.ChequeoDTO;
import com.ganadero.controganadero.dto.NuevoChequeoDTO;

public interface ChequeoService {

    public ChequeoDTO create (NuevoChequeoDTO chequeoDTO);
    public ChequeoDTO retrieve(Long id) throws Exception;
    public ChequeoDTO update(ChequeoDTO chequeoDTO,Long id) throws Exception;
    public void delete (Long id ) throws Exception;

    public List<ChequeoDTO> list();
}
