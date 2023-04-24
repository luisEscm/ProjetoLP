package mapeamento.map.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mapeamento.map.model.Producao;
import mapeamento.map.model.Orientacao;
import mapeamento.map.model.Producao;
import mapeamento.map.model.dto.Estatisticas;
import mapeamento.map.model.repositorio.ProducaoRepository;

@Service
public class ProducaoService {
    
    @Autowired
    ProducaoRepository repository;

    //public List<Integer> obterProducaoPPg(Integer idPrograma, Integer periodo){ }

    //public List<Producao> obterProducaoDocente(Integer idDocente, Integer periodo){ }

    public void associarOrientacaoProducao(Producao p, Orientacao o){ }

    public void associarEstatProducao(Producao p, Estatisticas e){ }
}
