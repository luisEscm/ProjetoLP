package mapeamento.map.model.repositorio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import mapeamento.map.model.Orientacao;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class OrientacaoRepositoryTest {
    
    @Autowired
    OrientacaoRepository repository;

    @Test
    public void deveVerificarSalvarDocente(){
        //Cenario
        Orientacao orientacao = Orientacao.builder().idOrientacao(1)
                                            .tipo("teste Tipo1")
                                            .discente("teste1")
                                            .titulo("testeTitulo1")
                                            .ano(1)
                                            .modalidade("testeModalidade1")
                                            .instituicao("testeIntituição1")
                                            .curso("testeCurso1")
                                            .status("teste")
                                            .build();
        
        //Ação
        Orientacao salvo = repository.save(orientacao);

        //Verificação
        Assertions.assertNotNull(salvo);
        Assertions.assertEquals(orientacao.getIdOrientacao(), salvo.getIdOrientacao());
        Assertions.assertEquals(orientacao.getTipo(), salvo.getTipo());
        Assertions.assertEquals(orientacao.getDiscente(), salvo.getDiscente());
        Assertions.assertEquals(orientacao.getTitulo(), salvo.getTitulo());
        Assertions.assertEquals(orientacao.getAno(), salvo.getAno());
        Assertions.assertEquals(orientacao.getModalidade(), salvo.getModalidade());
        Assertions.assertEquals(orientacao.getInstituicao(), salvo.getInstituicao());
        Assertions.assertEquals(orientacao.getCurso(), salvo.getCurso());
        Assertions.assertEquals(orientacao.getStatus(), salvo.getStatus());

    }

    @Test
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

    @Test
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
