package mapeamento.map.model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "producao")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Producao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_producao")
    private Integer idProducao;

    
    //ManyToMany para os docentes
    @ManyToMany(mappedBy = "producoes")
    private Set<Docente> docentes;


    //ManyToMany para as orientações
    @ManyToMany
    @JoinTable(
        name = "producao_orientacao",
        joinColumns = @JoinColumn(name = "id_orientacao"),
        inverseJoinColumns = @JoinColumn(name = "id_producao")
    )
    private Set<Orientacao> orientacoes;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "issn_ou_sigla")
    private String issnSigla;

    @Column(name = "nome_local")
    private String nomeLocal;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "ano")
    private Integer ano;

    @Column(name = "qualis")
    private String qualis;

    @Column(name = "percentile_ou_h5")
    private Integer percentileH5;

    @Column(name = "qtd_grad")
    private Integer qtdGrad;

    @Column(name = "qtd_mestrado")
    private Integer qtdMestrado;

    @Column(name = "qtd_doutorado")
    private Integer qtdDoutorado;
}
