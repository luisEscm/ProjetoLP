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
        repository.deleteAll();

        Docente docente = Docente.builder().idLattes("11")
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

    @Test
    public void deveVerificarContarDocentes(){
        //Cenario
        repository.deleteAll();

        Docente docente1 = Docente.builder()
                                            .idLattes("11")
                                            .nome("teste1")
                                            .dataAtualizacao(new Date())
                                            .build();
        
        Docente docente2 = Docente.builder()
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

    @Test
    public void deveVerificarEncontrarTodos(){
        //Cenario
        repository.deleteAll();
        Docente docente1 = Docente.builder()
                                            .idLattes("11")
                                            .nome("teste1")
                                            .dataAtualizacao(new Date())
                                            .build();

        Docente docente2 = Docente.builder()
                                            .idLattes("22")
                                            .nome("teste2")
                                            .dataAtualizacao(new Date())
                                            .build();

        repository.save(docente1);
        repository.save(docente2);
        List<Docente> docentesOriginal = new ArrayList<>();
        docentesOriginal.add(docente1);
        docentesOriginal.add(docente2);
        
        //Ação

        List<Docente> docentesEncontrados = repository.findAll();
        
        //Verificação
        Assertions.assertNotNull(docentesEncontrados);
        Assertions.assertEquals(docentesOriginal.get(0).getIdDocente(), docentesEncontrados.get(0).getIdDocente());
        Assertions.assertEquals(docentesOriginal.get(0).getIdLattes(), docentesEncontrados.get(0).getIdLattes());
        Assertions.assertEquals(docentesOriginal.get(0).getNome(), docentesEncontrados.get(0).getNome());
        //Assertions.assertEquals(docentesOriginal.get(0).getDataAtualizacao(), docentesEncontrados.get(0).getDataAtualizacao());
        Assertions.assertEquals(docentesOriginal.get(1).getIdDocente(), docentesEncontrados.get(1).getIdDocente());
        Assertions.assertEquals(docentesOriginal.get(1).getIdLattes(), docentesEncontrados.get(1).getIdLattes());
        Assertions.assertEquals(docentesOriginal.get(1).getNome(), docentesEncontrados.get(1).getNome());
        //Assertions.assertEquals(docentesOriginal.get(1).getDataAtualizacao(), docentesEncontrados.get(1).getDataAtualizacao());
        //<Exception in toString(): org.hibernate.LazyInitializationException: failed to lazily initialize a collection of role: mapeamento.map.model.Docente.orientacoes: could not initialize proxy - no Session>
    }

    @Test
    public void deveVerificarDeletarDocente(){
        //Cenario
        repository.deleteAll();
        Docente docente1 = Docente.builder()
                                            .idLattes("11")
                                            .nome("teste1")
                                            .dataAtualizacao(new Date())
                                            .build();
        
        Docente docente2 = Docente.builder()
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
        ArrayList<Docente> docentesDelet = (ArrayList<Docente>) repository.findAll();
        
        //Verificação
        Assertions.assertNotNull(docentesDelet);
        Assertions.assertNotEquals(docentesOriginal, docentesDelet);
        Assertions.assertEquals(docentesEsperado, docentesDelet);
        //<Exception in toString(): org.hibernate.LazyInitializationException: failed to lazily initialize a collection of role: mapeamento.map.model.Docente.orientacoes: could not initialize proxy - no Session>
    }

}
