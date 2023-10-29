package one.digitalinnovation.gof.service;

import one.digitalinnovation.gof.model.Associacao;

public interface AssosicaoService {
    Iterable<Associacao> buscarTodos();

    Associacao buscarPorId(Long id);

    void inserir(Associacao associacao);

    void deletar(Long id);
}
