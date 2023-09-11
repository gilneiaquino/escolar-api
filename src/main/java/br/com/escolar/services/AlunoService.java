package br.com.escolar.services;

import br.com.escolar.colecoes.Aluno;
import br.com.escolar.colecoes.Endereco;
import br.com.escolar.colecoes.Telefone;
import br.com.escolar.repositorios.AlunoRepository;
import br.com.escolar.repositorios.EnderecoRepository;
import br.com.escolar.repositorios.TelefoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {
    @Autowired
    private final AlunoRepository alunoRepository;

    @Autowired
    private TelefoneRepository telefoneRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;




    @Autowired
    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public Aluno salvarAluno(Aluno aluno) {
        Aluno alunoSalvo = alunoRepository.save(aluno);
        for (Endereco endereco : aluno.getEnderecos()) {
            endereco.setIdAluno(alunoSalvo.getId());
            enderecoRepository.save(endereco);
        }

        aluno.getTelefones();

        for (Telefone telefone: aluno.getTelefones()) {
            telefone.setIdAluno(alunoSalvo.getId());
            telefoneRepository.save(telefone);
        }
        return aluno;
    }

    public List<Aluno> listarTodosAlunos() {
        return alunoRepository.findAll();
    }

    public Aluno buscarAlunoPorId(String id) {
        Aluno aluno = alunoRepository.findById(id).orElse(null);

/*        if (aluno != null) {
            // Carregar os telefones e endereços associados
            List<Telefone> telefones = telefoneRepository.findByAlunoId(id);
            List<Endereco> enderecos = enderecoRepository.findByAlunoId(id);

            aluno.setTelefones(telefones);
            aluno.setEnderecos(enderecos);
        }*/

        return aluno;
    }


    public void excluirAluno(String id) {
        alunoRepository.deleteById(id);
    }

    public List<Aluno> consultarAlunos(String nome, String cpf, String matricula) {
        return alunoRepository.buscarAlunosPorNomeCpfMatricula(nome, cpf, matricula);
    }

 }
