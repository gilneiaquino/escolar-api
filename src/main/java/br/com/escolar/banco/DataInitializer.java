package br.com.escolar.banco;

import br.com.escolar.colecoes.Aluno;
import br.com.escolar.colecoes.Endereco;
import br.com.escolar.colecoes.Telefone;
import br.com.escolar.repositorios.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.time.LocalDate;



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

        Endereco enderecoAluno1 = new Endereco( "1","Rua A","25", "Cidade A", "Estado A", "12345-678");
        Telefone telefoneAluno1 = new Telefone("1","14","33147897", "Celular");


        Aluno aluno1 = new Aluno("1L","Marcos", LocalDate.of(1998,05,11), "Masculino", Arrays.asList(enderecoAluno1), Arrays.asList(telefoneAluno1),"teste@teste1.com","01145461148","123456");

        Endereco enderecoAluno2 = new Endereco("2L","25","Rua B", "Cidade B", "Estado B", "54321-876");
        Telefone telefoneAluno2 = new Telefone("2L","11","42553218", "Fixo");


        Aluno aluno2 = new Aluno("2L","Maria", LocalDate.of(1998,01,15), "Feminino",Arrays.asList( enderecoAluno2), Arrays.asList(telefoneAluno2),"teste@teste2.com","01145461448","123457");

        Endereco enderecoAluno3 = new Endereco("3L","Rua C","36", "Cidade C", "Estado C", "98765-432");
        Telefone telefoneAluno3 = new Telefone("3L","61","32553255", "Celular");


        Aluno aluno3 = new Aluno("3L","Pedro", LocalDate.of(2024,05,28), "Masculino",Arrays.asList( enderecoAluno3), Arrays.asList(telefoneAluno3),"teste@teste3.com","01145461177", "6798797987");

        // Salve os alunos no banco de dados
       alunoRepository.save(aluno1);
       alunoRepository.save(aluno2);
       alunoRepository.save(aluno3);
    }
}
