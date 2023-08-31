package br.com.escolar.banco;

import br.com.escolar.colecoes.Aluno;
import br.com.escolar.colecoes.Endereco;
import br.com.escolar.colecoes.Telefone;
import br.com.escolar.repositorios.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataInitializer implements CommandLineRunner {

    private final AlunoRepository alunoRepository;

    @Autowired
    public DataInitializer(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Endereco enderecoAluno1 = new Endereco(1L,"Rua A","25", "Cidade A", "Estado A", "12345-678");
        Telefone telefoneAluno1 = new Telefone(1L,"123-456-789", "Celular");

       Aluno aluno1 = new Aluno(1L,"Marcos", "1998-05-11", "Masculino", enderecoAluno1, Arrays.asList(telefoneAluno1));

        Endereco enderecoAluno2 = new Endereco(2L,"25","Rua B", "Cidade B", "Estado B", "54321-876");
        Telefone telefoneAluno2 = new Telefone(2L,"987-654-321", "Fixo");

        Aluno aluno2 = new Aluno(2L,"Maria", "1998-05-22", "Feminino", enderecoAluno2, Arrays.asList(telefoneAluno2));

        Endereco enderecoAluno3 = new Endereco(3L,"Rua C","36", "Cidade C", "Estado C", "98765-432");
        Telefone telefoneAluno3 = new Telefone(3L,"555-555-555", "Celular");

        Aluno aluno3 = new Aluno(3L,"Pedro", "1995-11-10", "Masculino", enderecoAluno3, Arrays.asList(telefoneAluno3));

        // Salve os alunos no banco de dados
       alunoRepository.save(aluno1);
       alunoRepository.save(aluno2);
       alunoRepository.save(aluno3);
    }
}
