package mapeamento.map.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mapeamento.map.model.Orientacao;
import mapeamento.map.model.repositorio.OrientacaoRepository;

@Service
public class OrientacaoService {
           
    @Autowired
    OrientacaoRepository repository;

    //public List<Integer> obterOrientacaoPPg(Integer idPrograma, Integer periodo){ }

    //public List<Orientacao> obterOrientacaoDocente(Integer idDocente, Integer periodo){ }
}
