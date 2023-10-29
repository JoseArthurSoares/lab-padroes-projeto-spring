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
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "associacaoes")
public class Associacao {

    @JsonProperty("id")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @JsonProperty("clienteId")
    @Column(nullable = false)
    private Long clienteId;

    @JsonProperty("jogoId")
    @Column(nullable = false)
    private Long jogoId;

    @JsonProperty("status")
    @Column(nullable = false)
    private boolean status;
}
