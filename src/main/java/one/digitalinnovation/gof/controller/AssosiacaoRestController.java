package one.digitalinnovation.gof.controller;

import one.digitalinnovation.gof.model.Associacao;
import one.digitalinnovation.gof.service.AssosicaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("associacoes")
public class AssosiacaoRestController {

    @Autowired
    private AssosicaoService assosicaoService;

    @GetMapping
    public ResponseEntity<Iterable<Associacao>> buscarTodos() {
        return ResponseEntity.ok(assosicaoService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Associacao> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(assosicaoService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Associacao> inserir(@RequestBody Associacao associacao) {
        assosicaoService.inserir(associacao);
        return ResponseEntity.ok(associacao);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        assosicaoService.deletar(id);
        return ResponseEntity.ok().build();
    }
}
