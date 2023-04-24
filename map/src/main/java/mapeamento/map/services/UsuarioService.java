package mapeamento.map.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mapeamento.map.model.repositorio.DocenteRepository;

@Service
public class UsuarioService {
            
    @Autowired
    DocenteRepository repository;

    public void login(){ }
}
