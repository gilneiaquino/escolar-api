package br.com.escolar.controllers;

import br.com.escolar.colecoes.Pagamento;
import br.com.escolar.repositorios.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {

    private final PagamentoRepository pagamentoRepository;

    @Autowired
    public PagamentoController(PagamentoRepository pagamentoRepository) {
        this.pagamentoRepository = pagamentoRepository;
    }

    @GetMapping
    public List<Pagamento> getAllPagamentos() {
        return pagamentoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Pagamento getPagamentoById(@PathVariable String id) {
        return pagamentoRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Pagamento createPagamento(@RequestBody Pagamento pagamento) {
        return pagamentoRepository.save(pagamento);
    }

    @PutMapping("/{id}")
    public Pagamento updatePagamento(@PathVariable String id, @RequestBody Pagamento pagamento) {
        pagamento.setId(id);
        return pagamentoRepository.save(pagamento);
    }

    @DeleteMapping("/{id}")
    public void deletePagamento(@PathVariable String id) {
        pagamentoRepository.deleteById(id);
    }
}
