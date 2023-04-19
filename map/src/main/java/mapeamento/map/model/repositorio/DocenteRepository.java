package mapeamento.map.model.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import mapeamento.map.model.Docente;

public interface DocenteRepository extends JpaRepository<Docente,Long> {
    
}
