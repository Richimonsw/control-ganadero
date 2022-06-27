package com.ganadero.controganadero.Service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ganadero.controganadero.Service.UsuarioService;
import com.ganadero.controganadero.dto.NuevoUsuarioDTO;
import com.ganadero.controganadero.dto.UsuarioDTO;
import com.ganadero.controganadero.exception.ResourceNotFoundException;
import com.ganadero.controganadero.models.Usuario;
import com.ganadero.controganadero.repositories.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    final ModelMapper   modelMapper;
    final UsuarioRepository usuarioRepository;
    
    public UsuarioServiceImpl(@Autowired UsuarioRepository repository, ModelMapper mapper){
        this.usuarioRepository = repository;
        this.modelMapper = mapper;
    }
    
    @Override
    @Transactional
    public UsuarioDTO create(NuevoUsuarioDTO usuarioDTO) {
        Usuario usuario = modelMapper.map(usuarioDTO, Usuario.class);
        usuarioRepository.save(usuario);
        return modelMapper.map(usuario, UsuarioDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public UsuarioDTO retrieve(Long id) throws Exception {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Usuario not found"));
        return modelMapper.map(usuario, UsuarioDTO.class);
    }

    @Override
    @Transactional
    public UsuarioDTO update(UsuarioDTO usuarioDTO, Long id) throws Exception {
        
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Usuario not found"));
        usuario.setId(id);
        usuario = modelMapper.map(usuarioDTO, Usuario.class);
        usuarioRepository.save(usuario);

        return modelMapper.map(usuario, UsuarioDTO.class);
    }

    @Override
    @Transactional
    public void delete(Long id) throws Exception {
        Usuario usuario = usuarioRepository.findById(id)
        .orElseThrow(()-> new ResourceNotFoundException("Usuario not found"));        
        usuarioRepository.deleteById(usuario.getId());  
        
    }

    @Override
    @Transactional(readOnly = true)
    public List<UsuarioDTO> list() {
        List<Usuario> usuarios= usuarioRepository.findAll();
        return usuarios.stream().map(usuario -> modelMapper.map(usuario, UsuarioDTO.class))
            .collect(Collectors.toList());  
    }
    
}
