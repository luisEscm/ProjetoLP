package mapeamento.map.model.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import mapeamento.map.model.Programa;

public interface ProgramaRepository extends JpaRepository<Programa, Long> {
    
}
