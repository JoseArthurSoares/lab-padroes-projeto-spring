package one.digitalinnovation.gof.repository;

import one.digitalinnovation.gof.model.Associacao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssociacaoRepository extends CrudRepository<Associacao, Long> {
}
