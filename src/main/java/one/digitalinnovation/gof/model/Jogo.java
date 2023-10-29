package one.digitalinnovation.gof.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "jogos")
public class Jogo {

    @JsonProperty("id")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @JsonProperty("nome")
    @Column(nullable = false)
    private String nome;

    @JsonProperty("genero")
    @Column(nullable = false)
    private String genero;

    @JsonProperty("ano")
    @Column(nullable = false)
    private String ano;

    @JsonProperty("cliente")
    @ManyToOne
    private Cliente Cliente;

    @JsonProperty("alugado")
    @Column(nullable = false)
    private Boolean alugado;
}
