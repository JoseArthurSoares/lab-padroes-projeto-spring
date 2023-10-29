package one.digitalinnovation.gof.service.impl;

import one.digitalinnovation.gof.model.Associacao;
import one.digitalinnovation.gof.model.Cliente;
import one.digitalinnovation.gof.model.Jogo;
import one.digitalinnovation.gof.repository.AssociacaoRepository;
import one.digitalinnovation.gof.repository.ClienteRepository;
import one.digitalinnovation.gof.repository.JogoRepository;
import one.digitalinnovation.gof.service.AssosicaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class AssociacaoServiceImpl implements AssosicaoService {

    @Autowired
    AssociacaoRepository associacaoRepository;
    @Autowired
    JogoRepository jogoRepository;
    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public Iterable<Associacao> buscarTodos() {
        return this.associacaoRepository.findAll();
    }

    @Override
    public Associacao buscarPorId(Long id) {
        return this.associacaoRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Associação não encontrada"));
    }

    @Override
    public void inserir(Associacao associacao) {
        Jogo jogo = this.jogoRepository
                .findById(associacao.getJogoId())
                .orElseThrow(() -> new EntityNotFoundException("Jogo não encontrado"));
        Cliente cliente = this.clienteRepository
                .findById(associacao.getClienteId())
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));
        jogo.setAlugado(true);
        jogo.setCliente(cliente);

        List<Jogo> jogosCliente = cliente.getJogos();
        jogosCliente.add(jogo);
        cliente.setJogos(jogosCliente);

        this.associacaoRepository.save(associacao);

        this.jogoRepository.save(jogo);
        this.clienteRepository.save(cliente);
    }


    @Override
    public void deletar(Long id) {
        Associacao associacao = this.associacaoRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Associação não encontrada"));

        Jogo jogo = this.jogoRepository
                .findById(associacao.getJogoId())
                .orElseThrow(() -> new EntityNotFoundException("Jogo não encontrado"));
        Cliente cliente = this.clienteRepository
                .findById(associacao.getClienteId())
                .orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));
        jogo.setAlugado(false);
        jogo.setCliente(null);

        List<Jogo> jogosCliente = cliente.getJogos();
        jogosCliente.remove(jogo);
        cliente.setJogos(jogosCliente);

        this.associacaoRepository.delete(associacao);

        this.jogoRepository.save(jogo);
        this.clienteRepository.save(cliente);
    }
}
