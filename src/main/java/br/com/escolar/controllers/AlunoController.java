package br.com.escolar.controllers;

import br.com.escolar.colecoes.Aluno;
import br.com.escolar.services.AlunoService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/api/alunos", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class AlunoController {
    private static final Logger logger = LoggerFactory.getLogger(AlunoController.class);


    private final AlunoService alunoService;

    @Autowired
    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @PostMapping
    public Aluno criarAluno(@Valid @RequestBody Aluno aluno) {
        return alunoService.salvarAluno(aluno);
    }

    @GetMapping
    public List<Aluno> listarAlunos() {
        return alunoService.listarTodosAlunos();
    }

    @GetMapping("/{id}")
    public Aluno buscarAlunoPorId(@PathVariable String id) {
        return alunoService.buscarAlunoPorId(id);
    }

    @PutMapping("/{id}")
    public Aluno atualizarAluno(@PathVariable String id, @RequestBody Aluno aluno) {
        aluno.setId(id);
        return alunoService.salvarAluno(aluno);
    }

    @DeleteMapping("/{id}")
    public void excluirAluno(@PathVariable String id) {
        alunoService.excluirAluno(id);
    }

    @GetMapping("/consultar")
    public ResponseEntity<List<Aluno>> consultar(
            @RequestParam(name = "nome", required = false) String nome,
            @RequestParam(name = "cpf", required = false) String cpf,
            @RequestParam(name = "matricula", required = false) String matricula) {

        List<Aluno> alunos = alunoService.consultarAlunos(nome, cpf, matricula);

        if (alunos.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(alunos);
        }
    }

}

