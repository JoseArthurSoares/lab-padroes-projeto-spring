package one.digitalinnovation.gof.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "clientes")
public class Cliente {

	@JsonProperty("id")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@JsonProperty("nome")
	@Column(nullable = false)
	private String nome;

	@JsonProperty("endereco")
	@ManyToOne
	private Endereco endereco;

	@JsonProperty
	@OneToMany
	private List<Jogo> jogos;
}
