package br.com.escolar.controllers;

import br.com.escolar.colecoes.Mensalidade;
import br.com.escolar.repositorios.MensalidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mensalidades")
public class MensalidadeController {

    private final MensalidadeRepository mensalidadeRepository;

    @Autowired
    public MensalidadeController(MensalidadeRepository mensalidadeRepository) {
        this.mensalidadeRepository = mensalidadeRepository;
    }

    @GetMapping
    public List<Mensalidade> getAllMensalidades() {
        return mensalidadeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Mensalidade getMensalidadeById(@PathVariable String id) {
        return mensalidadeRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Mensalidade createMensalidade(@RequestBody Mensalidade mensalidade) {
        return mensalidadeRepository.save(mensalidade);
    }

    @PutMapping("/{id}")
    public Mensalidade updateMensalidade(@PathVariable String id, @RequestBody Mensalidade mensalidade) {
        mensalidade.setId(id);
        return mensalidadeRepository.save(mensalidade);
    }

    @DeleteMapping("/{id}")
    public void deleteMensalidade(@PathVariable String id) {
        mensalidadeRepository.deleteById(id);
    }
}

