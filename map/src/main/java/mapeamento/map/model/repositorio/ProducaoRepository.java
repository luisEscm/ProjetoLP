package mapeamento.map.model.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import mapeamento.map.model.Producao;

public interface ProducaoRepository extends JpaRepository<Producao, Long> {
    
}
