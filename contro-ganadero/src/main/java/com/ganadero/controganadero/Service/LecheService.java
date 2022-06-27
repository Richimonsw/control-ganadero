package com.ganadero.controganadero.Service;

import java.util.List;

import com.ganadero.controganadero.dto.LecheDTO;
import com.ganadero.controganadero.dto.NuevaLecheDTO;

public interface LecheService {
    public LecheDTO create (NuevaLecheDTO lecheDTO);
    public LecheDTO retrieve(Long id) throws Exception;
    public LecheDTO update(LecheDTO lecheDTO,Long id) throws Exception;
    public void delete (Long id ) throws Exception;

    public List<LecheDTO> list();
    
}
