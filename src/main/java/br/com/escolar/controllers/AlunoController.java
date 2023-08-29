package br.com.escolar.controllers;

import br.com.escolar.colecoes.Aluno;
import br.com.escolar.repositorios.AlunoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/api/alunos", produces = "application/json", consumes = "application/json")
public class AlunoController {
    private static final Logger logger = LoggerFactory.getLogger(AlunoController.class);


    @Autowired
    private AlunoRepository alunoRepository;

    // Endpoint para criar um novo aluno
    @PostMapping
    public Aluno criarAluno(@RequestBody Aluno aluno) {
        logger.info("Chegou na criação:::");
        return alunoRepository.save(aluno);
    }

    // Endpoint para recuperar todos os alunos
    @GetMapping
    public List<Aluno> listarAlunos() {
        return alunoRepository.findAll();
    }

    // Endpoint para recuperar um aluno por ID
    @GetMapping("/{id}")
    public Aluno buscarAlunoPorId(@PathVariable Long id) {

        return alunoRepository.findById(id).orElse(null);
    }

    // Endpoint para atualizar um aluno por ID
    @PutMapping("/{id}")
    public Aluno atualizarAluno(@PathVariable Long id, @RequestBody Aluno aluno) {
        aluno.setId(id);
        return alunoRepository.save(aluno);
    }

    // Endpoint para excluir um aluno por ID
    @DeleteMapping("/{id}")
    public void deletarAluno(@PathVariable Long id) {
        alunoRepository.deleteById(id);
    }
}

