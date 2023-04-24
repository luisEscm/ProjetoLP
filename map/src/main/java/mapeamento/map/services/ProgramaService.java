package mapeamento.map.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mapeamento.map.model.Docente;
import mapeamento.map.model.Orientacao;
import mapeamento.map.model.Programa;
import mapeamento.map.model.repositorio.ProgramaRepository;

@Service
public class ProgramaService {
    
    @Autowired
    ProgramaRepository repository;

    //public List<Programa> obterPrograma(String nome){ }

    //public List<Docente> obterDocentesPrograma(Integer idPrograma){ }

    //public List<Integer> obterIndices(Integer idPrograma, Integer periodo){ }

    //public List<Orientacao> ObterOrientacoes(Integer idPrograma, Integer periodo){ }
}
