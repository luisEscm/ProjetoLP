package mapeamento.map.model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "orientacao")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Orientacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_orientacao")
    private Integer idOrientacao;

    //ManyToMany para as tecnicas
    @ManyToMany(mappedBy = "orientacoes")
    private Set<Tecnica> tecnicas;


    //ManyToMany para as produções
    @ManyToMany(mappedBy = "orientacoes")
    private Set<Producao> producoes;

    
    //ManyToOne para o docente
    @ManyToOne
    @JoinColumn(name = "id_docente")
    private Docente docente;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "discente")
    private String discente;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "ano")
    private Integer ano;

    @Column(name = "modalidade")
    private String modalidade;

    @Column(name = "instituicao")
    private String instituicao;

    @Column(name = "curso")
    private String curso;

    @Column(name = "status")
    private String status;
}
