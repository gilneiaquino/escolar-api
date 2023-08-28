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
        // Crie e insira alguns alunos no banco de dados MongoDB
        Aluno aluno1 = new Aluno(1L, "João", "1990-01-01", "Masculino", new Endereco(1L, "Rua 123", "123", "Cidade A", "Estado A", "12345"), Arrays.asList(new Telefone(1L, "123456789", "Celular")));
        Aluno aluno2 = new Aluno(2L, "Maria", "1992-03-15", "Feminino", new Endereco(2L, "Rua 456", "456", "Cidade B", "Estado B", "54321"), Arrays.asList(new Telefone(2L, "987654321", "Fixo")));

        // Salve os alunos no banco de dados
        alunoRepository.save(aluno1);
        alunoRepository.save(aluno2);
    }
}
