package mapeamento.map.model.repositorio;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
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
        Orientacao orientacao = Orientacao.builder()
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
        repository.deleteAll();
        Orientacao orientacao1 = Orientacao.builder()
                                            .tipo("teste Tipo1")
                                            .discente("teste1")
                                            .titulo("testeTitulo1")
                                            .ano(1)
                                            .modalidade("testeModalidade1")
                                            .instituicao("testeIntituição1")
                                            .curso("testeCurso1")
                                            .status("teste1")
                                            .build();
        
        Orientacao orientacao2 = Orientacao.builder()
                                            .tipo("teste Tipo2")
                                            .discente("teste2")
                                            .titulo("testeTitulo2")
                                            .ano(2)
                                            .modalidade("testeModalidade2")
                                            .instituicao("testeIntituição2")
                                            .curso("testeCurso2")
                                            .status("teste2")
                                            .build();
        
        repository.save(orientacao1);
        repository.save(orientacao2);

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
        Orientacao orientacao1 = Orientacao.builder()
                                            .tipo("teste Tipo1")
                                            .discente("teste1")
                                            .titulo("testeTitulo1")
                                            .ano(1)
                                            .modalidade("testeModalidade1")
                                            .instituicao("testeIntituição1")
                                            .curso("testeCurso1")
                                            .status("teste1")
                                            .build();
        
        Orientacao orientacao2 = Orientacao.builder()
                                            .tipo("teste Tipo2")
                                            .discente("teste2")
                                            .titulo("testeTitulo2")
                                            .ano(2)
                                            .modalidade("testeModalidade2")
                                            .instituicao("testeIntituição2")
                                            .curso("testeCurso2")
                                            .status("teste2")
                                            .build();

        repository.save(orientacao1);
        repository.save(orientacao2);
        List<Orientacao> orientacaosOriginal = new ArrayList<>();
        orientacaosOriginal.add(orientacao1);
        orientacaosOriginal.add(orientacao2);

        List<Orientacao> orientacaosEsperado = new ArrayList<>();
        orientacaosEsperado.add(orientacao1);

        //Ação
        repository.delete(orientacao2);
        List<Orientacao> orientacaosDelet = repository.findAll();
        
        //Verificação
        Assertions.assertNotNull(orientacaosDelet);
        Assertions.assertNotEquals(orientacaosOriginal, orientacaosDelet);
        Assertions.assertEquals(orientacaosEsperado, orientacaosDelet);
    }
}
