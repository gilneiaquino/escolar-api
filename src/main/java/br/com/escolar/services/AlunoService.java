package br.com.escolar.services;

import br.com.escolar.colecoes.Aluno;
import br.com.escolar.repositorios.AlunoRepository;
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

    public Aluno buscarAlunoPorId(Long id) {
        return alunoRepository.findById(id).orElse(null);
    }

    public void excluirAluno(Long id) {
        alunoRepository.deleteById(id);
    }

    // Outros métodos de serviço conforme necessário
}
