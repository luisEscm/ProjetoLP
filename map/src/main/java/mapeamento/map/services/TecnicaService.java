package mapeamento.map.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mapeamento.map.model.Tecnica;
import mapeamento.map.model.Orientacao;
import mapeamento.map.model.Tecnica;
import mapeamento.map.model.dto.Estatisticas;
import mapeamento.map.model.repositorio.TecnicaRepository;

@Service
public class TecnicaService {
        
    @Autowired
    TecnicaRepository repository;

    //public List<Integer> obterTecnicaPPg(Integer idPrograma, Integer periodo){ }

    //public List<Tecnica> obterTecnicaDocente(Integer idDocente, Integer periodo){ }

    public void associarOrientacaoTecnica(Tecnica t, Orientacao o){ }

    public void associarEstatTecnica(Tecnica t, Estatisticas e){ }
}
