package com.ganadero.controganadero.Service;

import java.util.List;

import com.ganadero.controganadero.dto.CarneDTO;
import com.ganadero.controganadero.dto.NuevaCarneDTO;



public interface CarneService {

    public CarneDTO create (NuevaCarneDTO carneDTIO);
    public CarneDTO retrieve(Long id) throws Exception;
    public CarneDTO update(CarneDTO carneDTIO,Long id) throws Exception;
    public void delete (Long id ) throws Exception;

    public List<CarneDTO> list();
}
