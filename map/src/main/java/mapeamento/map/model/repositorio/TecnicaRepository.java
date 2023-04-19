package mapeamento.map.model.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import mapeamento.map.model.Tecnica;

public interface TecnicaRepository extends JpaRepository<Tecnica, Long> {
    
}
