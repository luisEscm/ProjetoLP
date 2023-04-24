package mapeamento.map.model.repositorio;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import mapeamento.map.model.Programa;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ProgramaRepositoryTest {
            
    @Autowired
    ProgramaRepository repository;

    @Test
    public void deveVerificarSalvarDocente(){
        //Cenario
        Programa programa = Programa.builder()
                                                .nome("teste1")
                                                .build();
        
        //Ação
        Programa salvo = repository.save(programa);

        //Verificação
        Assertions.assertNotNull(salvo);
        Assertions.assertEquals(programa.getIdPrograma(), salvo.getIdPrograma());
        Assertions.assertEquals(programa.getNome(), salvo.getNome());

    }

    @Test
    public void deveVerificarContarDocentes(){
        //Cenario
        repository.deleteAll();
        Programa programa1 = Programa.builder()
                                                .nome("teste1")
                                                .build();
        
        Programa programa2 = Programa.builder()
                                                .nome("teste2")
                                                .build();
        
        repository.save(programa1);
        repository.save(programa2);

        //Ação
        Long contagem = repository.count();

        //Verificação
        Assertions.assertNotNull(contagem);
        Assertions.assertEquals(contagem, 2);
    }

    @Test
    public void deveVerificarDeletarDocente(){
        //Cenario
        repository.deleteAll();
        Programa programa1 = Programa.builder()
                                            .nome("teste1")
                                            .build();
        
        Programa programa2 = Programa.builder()
                                            .nome("teste2")
                                            .build();

        repository.save(programa1);
        repository.save(programa2);
        List<Programa> programasOriginal = new ArrayList<>();
        programasOriginal.add(programa1);
        programasOriginal.add(programa2);

        List<Programa> programasEsperado = new ArrayList<>();
        programasEsperado.add(programa1);

        //Ação
        repository.delete(programa2);
        List<Programa> programasDelet = repository.findAll();
        
        //Verificação
        Assertions.assertNotNull(programasDelet);
        Assertions.assertNotEquals(programasOriginal, programasDelet);
        Assertions.assertEquals(programasEsperado, programasDelet);
    }
}
