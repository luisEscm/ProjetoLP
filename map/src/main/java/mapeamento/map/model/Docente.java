package mapeamento.map.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "docente")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Docente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_docente")
    private Integer idDocente;


    //OneToMany para as orientações 
    @OneToMany(mappedBy = "docente")
    private List<Orientacao> orientacoes;


    //ManyToMany para os programas
    @ManyToMany(mappedBy = "docentes")
    private List<Programa> programas;


    //ManyToMany para as tecnicas
    @ManyToMany
    @JoinTable(
        name = "docente_tecnica",
        joinColumns = @JoinColumn(name = "id_docente"),
        inverseJoinColumns = @JoinColumn(name = "id_tecnica")
    )
    private List<Tecnica> tecnicas;


    //ManyToMany para as produções
    @ManyToMany
    @JoinTable(
        name = "docente_producao",
        joinColumns = @JoinColumn(name = "id_docente"),
        inverseJoinColumns = @JoinColumn(name = "id_producao")
    )
    private List<Producao> producoes;

    @Column(name = "id_lattes")
    private String idLattes;

    @Column(name = "nome")
    private String nome;

    @Column(name = "data_atualizacao")
    private Date dataAtualizacao;
}

/*
spring.datasource.url= jdbc:postgresql://localhost:5544/mapeamento
spring.datasource.username=map
spring.datasource.password=emento
spring.jpa.hibernate.ddl-auto=upadate


spring.h2.console.enabled
spring.h2.console.path=/h2-console
 */
