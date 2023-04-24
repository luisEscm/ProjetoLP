package mapeamento.map.model.repositorio;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import mapeamento.map.model.Producao;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ProducaoRepositoryTest {
            
    @Autowired
    ProducaoRepository repository;

    @Test
    public void deveVerificarSalvarDocente(){
        //Cenario
        Producao producao = Producao.builder()
                                            .tipo("teste Tipo1")
                                            .issnSigla("testeSigla1")
                                            .nomeLocal("testeLocal1")
                                            .titulo("TesteTitulo1")
                                            .ano(1)
                                            .qualis("testeQualis1")
                                            .percentileH5(1)
                                            .qtdGrad(1)
                                            .qtdMestrado(1)
                                            .qtdDoutorado(1)
                                            .build();
        
        //Ação
        Producao salvo = repository.save(producao);

        //Verificação
        Assertions.assertNotNull(salvo);
        Assertions.assertEquals(producao.getIdProducao(), salvo.getIdProducao());
        Assertions.assertEquals(producao.getTipo(), salvo.getTipo());
        Assertions.assertEquals(producao.getIssnSigla(), salvo.getIssnSigla());
        Assertions.assertEquals(producao.getNomeLocal(), salvo.getNomeLocal());
        Assertions.assertEquals(producao.getTitulo(), salvo.getTitulo());
        Assertions.assertEquals(producao.getAno(), salvo.getAno());
        Assertions.assertEquals(producao.getQualis(), salvo.getQualis());
        Assertions.assertEquals(producao.getPercentileH5(), salvo.getPercentileH5());
        Assertions.assertEquals(producao.getQtdGrad(), salvo.getQtdGrad());
        Assertions.assertEquals(producao.getQtdMestrado(), salvo.getQtdMestrado());
        Assertions.assertEquals(producao.getQtdDoutorado(), salvo.getQtdDoutorado());

    }

    @Test
    public void deveVerificarContarDocentes(){
        //Cenario
        repository.deleteAll();
        Producao producao1 = Producao.builder()
                                                .tipo("teste Tipo1")
                                                .issnSigla("testeSigla1")
                                                .nomeLocal("testeLocal1")
                                                .titulo("TesteTitulo1")
                                                .ano(1)
                                                .qualis("testeQualis1")
                                                .percentileH5(1)
                                                .qtdGrad(1)
                                                .qtdMestrado(1)
                                                .qtdDoutorado(1)
                                                .build();
        
        Producao producao2 = Producao.builder()
                                                .tipo("teste Tipo2")
                                                .issnSigla("testeSigla2")
                                                .nomeLocal("testeLocal2")
                                                .titulo("TesteTitulo2")
                                                .ano(2)
                                                .qualis("testeQualis2")
                                                .percentileH5(2)
                                                .qtdGrad(2)
                                                .qtdMestrado(2)
                                                .qtdDoutorado(2)
                                                .build();
        
        repository.save(producao1);
        repository.save(producao2);

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
        Producao producao1 = Producao.builder()
                                                .tipo("teste Tipo1")
                                                .issnSigla("testeSigla1")
                                                .nomeLocal("testeLocal1")
                                                .titulo("TesteTitulo1")
                                                .ano(1)
                                                .qualis("testeQualis1")
                                                .percentileH5(1)
                                                .qtdGrad(1)
                                                .qtdMestrado(1)
                                                .qtdDoutorado(1)
                                                .build();
        
        Producao producao2 = Producao.builder()
                                                .tipo("teste Tipo2")
                                                .issnSigla("testeSigla2")
                                                .nomeLocal("testeLocal2")
                                                .titulo("TesteTitulo2")
                                                .ano(2)
                                                .qualis("testeQualis2")
                                                .percentileH5(2)
                                                .qtdGrad(2)
                                                .qtdMestrado(2)
                                                .qtdDoutorado(2)
                                                .build();

        repository.save(producao1);
        repository.save(producao2);
        List<Producao> producaosOriginal = new ArrayList<>();
        producaosOriginal.add(producao1);
        producaosOriginal.add(producao2);

        List<Producao> producaosEsperado = new ArrayList<>();
        producaosEsperado.add(producao1);

        //Ação
        repository.delete(producao2);
        List<Producao> producaosDelet = repository.findAll();
        
        //Verificação
        Assertions.assertNotNull(producaosDelet);
        Assertions.assertNotEquals(producaosOriginal, producaosDelet);
        Assertions.assertEquals(producaosEsperado, producaosDelet);
    }
}
