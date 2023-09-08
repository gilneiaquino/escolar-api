package br.com.escolar.services;

import br.com.escolar.colecoes.Aluno;
import br.com.escolar.repositorios.AlunoRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;

    @Autowired
    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public Aluno salvarAluno(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public List<Aluno> listarTodosAlunos() {
        return alunoRepository.findAll();
    }

    public Aluno buscarAlunoPorId(String id) {
        return alunoRepository.findById(id).orElse(null);
    }

    public void excluirAluno(String id) {
        alunoRepository.deleteById(id);
    }

    public List<Aluno> consultarAlunos(String nome, String cpf, String matricula) {
        return alunoRepository.buscarAlunosPorNomeCpfMatricula(nome, cpf, matricula);
    }

 }
