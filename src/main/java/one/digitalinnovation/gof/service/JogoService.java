package one.digitalinnovation.gof.service;

import one.digitalinnovation.gof.model.Jogo;

public interface JogoService {
    Iterable<Jogo> buscarTodos();

    Jogo buscarPorId(Long id);

    void inserir(Jogo jogo);

    void atualizar(Long id, Jogo jogo);

    Boolean isAlugado(Long id);

    void deletar(Long id);
}
