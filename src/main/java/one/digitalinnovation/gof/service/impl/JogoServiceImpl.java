package one.digitalinnovation.gof.service.impl;

import one.digitalinnovation.gof.model.Jogo;
import one.digitalinnovation.gof.repository.JogoRepository;
import one.digitalinnovation.gof.service.JogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class JogoServiceImpl implements JogoService {

    @Autowired
    private JogoRepository jogoRepository;
    @Override
    public Iterable<Jogo> buscarTodos() {
        return jogoRepository.findAll();
    }

    @Override
    public Jogo buscarPorId(Long id) {
        return this.jogoRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Jogo não encontrado"));
    }

    @Override
    public void inserir(Jogo jogo) {
        this.jogoRepository.save(jogo);
    }

    @Override
    public void atualizar(Long id, Jogo jogo) {
        this.jogoRepository.findById(id).ifPresent(j -> {
            j.setAno(jogo.getAno());
            j.setNome(jogo.getNome());
            j.setGenero(jogo.getGenero());
            this.jogoRepository.save(j);
        });
    }

    @Override
    public Boolean isAlugado(Long id) {
        Jogo jogo = this.jogoRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Jogo não encontrado"));
        return jogo.getAlugado();
    }

    @Override
    public void deletar(Long id) {
        Jogo jogo = this.jogoRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Jogo não encontrado"));
        this.jogoRepository.delete(jogo);
    }
}
