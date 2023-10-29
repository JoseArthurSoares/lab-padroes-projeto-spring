package one.digitalinnovation.gof.repository;

import one.digitalinnovation.gof.model.Jogo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JogoRepository extends CrudRepository<Jogo, Long> {
}
