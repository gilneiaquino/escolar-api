package br.com.escolar.controllers;

import br.com.escolar.colecoes.FormaPagamento;
import br.com.escolar.repositorios.FormaPagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/formasPagamento")
public class FormaPagamentoController {

    private final FormaPagamentoRepository formaPagamentoRepository;

    @Autowired
    public FormaPagamentoController(FormaPagamentoRepository formaPagamentoRepository) {
        this.formaPagamentoRepository = formaPagamentoRepository;
    }

    @GetMapping
    public List<FormaPagamento> getAllFormasPagamento() {
        return formaPagamentoRepository.findAll();
    }

    @GetMapping("/{id}")
    public FormaPagamento getFormaPagamentoById(@PathVariable String id) {
        return formaPagamentoRepository.findById(id).orElse(null);
    }

    @PostMapping
    public FormaPagamento createFormaPagamento(@RequestBody FormaPagamento formaPagamento) {
        return formaPagamentoRepository.save(formaPagamento);
    }

    @PutMapping("/{id}")
    public FormaPagamento updateFormaPagamento(@PathVariable String id, @RequestBody FormaPagamento formaPagamento) {
        formaPagamento.setId(id);
        return formaPagamentoRepository.save(formaPagamento);
    }

    @DeleteMapping("/{id}")
    public void deleteFormaPagamento(@PathVariable String id) {
        formaPagamentoRepository.deleteById(id);
    }
}
