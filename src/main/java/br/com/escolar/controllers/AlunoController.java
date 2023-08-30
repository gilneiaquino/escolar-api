package br.com.escolar.controllers;

import br.com.escolar.colecoes.Aluno;
import br.com.escolar.repositorios.AlunoRepository;
import br.com.escolar.services.AlunoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/api/alunos", produces = "application/json", consumes = "application/json")
public class AlunoController {
    private static final Logger logger = LoggerFactory.getLogger(AlunoController.class);


    private final AlunoService alunoService;

    @Autowired
    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @PostMapping
    public Aluno criarAluno(@RequestBody Aluno aluno) {
        return alunoService.salvarAluno(aluno);
    }

    @GetMapping
    public List<Aluno> listarAlunos() {
        return alunoService.listarTodosAlunos();
    }

    @GetMapping("/{id}")
    public Aluno buscarAlunoPorId(@PathVariable Long id) {
        return alunoService.buscarAlunoPorId(id);
    }

    @PutMapping("/{id}")
    public Aluno atualizarAluno(@PathVariable Long id, @RequestBody Aluno aluno) {
        aluno.setId(id);
        return alunoService.salvarAluno(aluno);
    }

    @DeleteMapping("/{id}")
    public void excluirAluno(@PathVariable Long id) {
        alunoService.excluirAluno(id);
    }

}

