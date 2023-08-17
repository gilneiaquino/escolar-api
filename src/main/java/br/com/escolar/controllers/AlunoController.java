package br.com.escolar.controllers;

import br.com.escolar.colecoes.Aluno;
import br.com.escolar.repositorios.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoRepository alunoRepository;

    @Autowired
    public AlunoController(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    @GetMapping
    public List<Aluno> getAllAlunos() {
        return alunoRepository.findAll();
    }

    @PostMapping
    public Aluno createAluno(@RequestBody Aluno aluno) {
        return alunoRepository.save(aluno);
    }
}

