package one.digitalinnovation.gof.controller;

import one.digitalinnovation.gof.model.Jogo;
import one.digitalinnovation.gof.service.JogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("jogos")
public class JogoRestController {

    @Autowired
    JogoService jogoService;

    @GetMapping
    public ResponseEntity<Iterable<Jogo>> buscarTodos() {
        return ResponseEntity.ok(jogoService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jogo> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(jogoService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Jogo> inserir(@RequestBody Jogo jogo) {
        jogoService.inserir(jogo);
        return ResponseEntity.ok(jogo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Jogo> atualizar(@PathVariable Long id, @RequestBody Jogo jogo) {
        jogoService.atualizar(id, jogo);
        return ResponseEntity.ok(jogo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        jogoService.deletar(id);
        return ResponseEntity.ok().build();
    }
}
