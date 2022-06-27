package com.ganadero.controganadero.Service;

import java.util.List;

import com.ganadero.controganadero.dto.NuevoUsuarioDTO;
import com.ganadero.controganadero.dto.UsuarioDTO;

public interface UsuarioService {

    public UsuarioDTO create (NuevoUsuarioDTO usuarioDTO);
    public UsuarioDTO retrieve(Long id) throws Exception;
    public UsuarioDTO update(UsuarioDTO usuarioDTO,Long id) throws Exception;
    public void delete (Long id ) throws Exception;

    public List<UsuarioDTO> list();
    
}
