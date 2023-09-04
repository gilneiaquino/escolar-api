package br.com.escolar.controllers;

import br.com.escolar.colecoes.Telefone;
import br.com.escolar.repositorios.TelefoneRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/telefones")
public class TelefoneController {

    private final TelefoneRepository telefoneRepository;

    @Autowired
    public TelefoneController(TelefoneRepository telefoneRepository) {
        this.telefoneRepository = telefoneRepository;
    }

    @GetMapping
    public List<Telefone> getAllTelefones() {
        return telefoneRepository.findAll();
    }

    @GetMapping("/{id}")
    public Telefone getTelefoneById(@PathVariable String id) {
        return telefoneRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Telefone createTelefone(@RequestBody Telefone telefone) {
        return telefoneRepository.save(telefone);
    }

    @PutMapping("/{id}")
    public Telefone updateTelefone(@PathVariable String id, @RequestBody Telefone telefone) {
        telefone.setId(id);
        return telefoneRepository.save(telefone);
    }

    @DeleteMapping("/{id}")
    public void deleteTelefone(@PathVariable String id) {
        telefoneRepository.deleteById(id);
    }
}

