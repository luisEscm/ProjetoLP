package mapeamento.map.model.repositorio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import mapeamento.map.model.Docente;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class DocenteRepositoryTest {
    @Autowired
    DocenteRepository repository;

    @Test
    public void deveVerificarSalvarDocente(){
        //Cenario
        Docente docente = Docente.builder().idDocente(1)
                                            .idLattes("11")
                                            .nome("teste")
                                            .dataAtualizacao(new Date())
                                            .build();
        
        //Ação
        Docente salvo = repository.save(docente);

        //Verificação
        Assertions.assertNotNull(salvo);
        Assertions.assertEquals(docente.getIdDocente(), salvo.getIdDocente());
        Assertions.assertEquals(docente.getIdLattes(), salvo.getIdLattes());
        Assertions.assertEquals(docente.getNome(), salvo.getNome());
        Assertions.assertEquals(docente.getDataAtualizacao(), salvo.getDataAtualizacao());

    }

    public void deveVerificarContarDocentes(){
        //Cenario
        Docente docente1 = Docente.builder().idDocente(1)
                                            .idLattes("11")
                                            .nome("teste1")
                                            .dataAtualizacao(new Date())
                                            .build();
        
        Docente docente2 = Docente.builder().idDocente(2)
                                            .idLattes("22")
                                            .nome("teste2")
                                            .dataAtualizacao(new Date())
                                            .build();
        
        repository.save(docente1);
        repository.save(docente2);

        //Ação
        Long contagem = repository.count();

        //Verificação
        Assertions.assertNotNull(contagem);
        Assertions.assertEquals(contagem, 2);
    }

    public void deveVerificarDeletarDocente(){
        //Cenario
        Docente docente1 = Docente.builder().idDocente(1)
                                            .idLattes("11")
                                            .nome("teste1")
                                            .dataAtualizacao(new Date())
                                            .build();
        
        Docente docente2 = Docente.builder().idDocente(2)
                                            .idLattes("22")
                                            .nome("teste2")
                                            .dataAtualizacao(new Date())
                                            .build();

        repository.save(docente1);
        repository.save(docente2);
        List<Docente> docentesOriginal = new ArrayList<>();
        docentesOriginal.add(docente1);
        docentesOriginal.add(docente2);

        List<Docente> docentesEsperado = new ArrayList<>();
        docentesEsperado.add(docente1);

        //Ação
        repository.delete(docente2);
        List<Docente> docentesDelet = repository.findAll();
        
        //Verificação
        Assertions.assertNotNull(docentesDelet);
        Assertions.assertNotEquals(docentesOriginal, docentesDelet);
        Assertions.assertEquals(docentesEsperado, docentesDelet);
    }

}
