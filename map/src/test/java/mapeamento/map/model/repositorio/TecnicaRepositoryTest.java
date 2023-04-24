package mapeamento.map.model.repositorio;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import mapeamento.map.model.Tecnica;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class TecnicaRepositoryTest {
            
    @Autowired
    TecnicaRepository repository;

    @Test
    public void deveVerificarSalvarDocente(){
        //Cenario
        Tecnica tecnica = Tecnica.builder()
                                            .tipo("teste Tipo1")
                                            .titulo("testeTitulo1")
                                            .ano(1)
                                            .financiadora("testefinanciadora1")
                                            .informacoes("testeInformação1")
                                            .qtdGrad(1)
                                            .qtdMestrado(1)
                                            .qtdDoutorado(1)
                                            .build();
        
        //Ação
        Tecnica salvo = repository.save(tecnica);

        //Verificação
        Assertions.assertNotNull(salvo);
        Assertions.assertEquals(tecnica.getIdTecnica(), salvo.getIdTecnica());
        Assertions.assertEquals(tecnica.getTipo(), salvo.getTipo());
        Assertions.assertEquals(tecnica.getTitulo(), salvo.getTitulo());
        Assertions.assertEquals(tecnica.getAno(), salvo.getAno());
        Assertions.assertEquals(tecnica.getFinanciadora(), salvo.getFinanciadora());
        Assertions.assertEquals(tecnica.getInformacoes(), salvo.getInformacoes());
        Assertions.assertEquals(tecnica.getQtdGrad(), salvo.getQtdGrad());
        Assertions.assertEquals(tecnica.getQtdMestrado(), salvo.getQtdMestrado());
        Assertions.assertEquals(tecnica.getQtdDoutorado(), salvo.getQtdDoutorado());

    }

    @Test
    public void deveVerificarContarDocentes(){
        //Cenario
        repository.deleteAll();
        Tecnica tecnica1 = Tecnica.builder()
                                            .tipo("teste Tipo1")
                                            .titulo("testeTitulo1")
                                            .ano(1)
                                            .financiadora("testefinanciadora1")
                                            .informacoes("testeInformação1")
                                            .qtdGrad(1)
                                            .qtdMestrado(1)
                                            .qtdDoutorado(1)
                                            .build();
        
        Tecnica tecnica2 = Tecnica.builder()
                                            .tipo("teste Tipo2")
                                            .titulo("testeTitulo2")
                                            .ano(2)
                                            .financiadora("testefinanciadora2")
                                            .informacoes("testeInformação2")
                                            .qtdGrad(2)
                                            .qtdMestrado(2)
                                            .qtdDoutorado(2)
                                            .build();
        
        repository.save(tecnica1);
        repository.save(tecnica2);

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
        Tecnica tecnica1 = Tecnica.builder()
                                            .tipo("teste Tipo1")
                                            .titulo("testeTitulo1")
                                            .ano(1)
                                            .financiadora("testefinanciadora1")
                                            .informacoes("testeInformação1")
                                            .qtdGrad(1)
                                            .qtdMestrado(1)
                                            .qtdDoutorado(1)
                                            .build();
        
        Tecnica tecnica2 = Tecnica.builder()
                                            .tipo("teste Tipo2")
                                            .titulo("testeTitulo2")
                                            .ano(2)
                                            .financiadora("testefinanciadora2")
                                            .informacoes("testeInformação2")
                                            .qtdGrad(2)
                                            .qtdMestrado(2)
                                            .qtdDoutorado(2)
                                            .build();
        repository.save(tecnica1);
        List<Tecnica> tecnicasOriginal = new ArrayList<>();
        tecnicasOriginal.add(tecnica1);
        tecnicasOriginal.add(tecnica2);

        List<Tecnica> tecnicasEsperado = repository.findAll();
        repository.save(tecnica2);

        //Ação
        repository.delete(tecnica2);
        List<Tecnica> tecnicasDelet = repository.findAll();
        
        //Verificação
        Assertions.assertNotNull(tecnicasDelet);
        Assertions.assertNotEquals(tecnicasOriginal, tecnicasDelet);
        Assertions.assertEquals(tecnicasEsperado, tecnicasDelet);
    }
}
