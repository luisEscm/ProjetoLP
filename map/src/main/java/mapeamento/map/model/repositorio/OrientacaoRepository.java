package mapeamento.map.model.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import mapeamento.map.model.Orientacao;

public interface OrientacaoRepository extends JpaRepository<Orientacao, Long> {
    
}
