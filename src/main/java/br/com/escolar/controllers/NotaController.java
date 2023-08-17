package br.com.escolar.controllers;

import br.com.escolar.colecoes.Nota;
import br.com.escolar.repositorios.NotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notas")
public class NotaController {

    private final NotaRepository notaRepository;

    @Autowired
    public NotaController(NotaRepository notaRepository) {
        this.notaRepository = notaRepository;
    }

    @GetMapping
    public List<Nota> getAllNotas() {
        return notaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Nota getNotaById(@PathVariable String id) {
        return notaRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Nota createNota(@RequestBody Nota nota) {
        return notaRepository.save(nota);
    }

    @PutMapping("/{id}")
    public Nota updateNota(@PathVariable String id, @RequestBody Nota nota) {
        nota.setId(id);
        return notaRepository.save(nota);
    }

    @DeleteMapping("/{id}")
    public void deleteNota(@PathVariable String id) {
        notaRepository.deleteById(id);
    }
}
