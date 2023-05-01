package mapeamento.map.model;

import java.util.List;

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
@Table(name = "tecnica")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Tecnica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_tecnica")
    private Integer idTecnica;

    // ManyToMany para as Orientações
    @ManyToMany
    @JoinTable(
        name = "tecnica_orientacao",
        joinColumns = @JoinColumn(name = "id_tecnica"),
        inverseJoinColumns = @JoinColumn(name = "id_orientacao")
    )
    private List<Orientacao> orientacoes;

    
    //ManyToMany para os docentes
    @ManyToMany(mappedBy = "tecnicas")
    private List<Docente> docentes;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "ano")
    private Integer ano;

    @Column(name = "financiadora")
    private String financiadora;

    @Column(name = "outras_informacaoes")
    private String informacoes;

    @Column(name = "qtd_grad")
    private Integer qtdGrad;

    @Column(name = "qtd_mestrado")
    private Integer qtdMestrado;

    @Column(name = "qtd_doutorado")
    private Integer qtdDoutorado;


}
