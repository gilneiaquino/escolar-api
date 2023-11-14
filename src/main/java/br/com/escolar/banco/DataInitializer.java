package br.com.escolar.banco;

import br.com.escolar.colecoes.*;
import br.com.escolar.repositorios.AlunoRepository;
import br.com.escolar.repositorios.CursoRepository;
import br.com.escolar.repositorios.PerfilRepository;
import br.com.escolar.repositorios.UsuarioRepository;
import br.com.escolar.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private PerfilRepository perfilRepository;


    @Override
    public void run(String... args) throws Exception {
        carregarAlunos();
        carregarCursos();
        carregarListaUsuario();
    }

    private void carregarAlunos() {
        Endereco enderecoAluno1 = new Endereco("1", "Rua A", "25", "Cidade A", "Estado A", "12345-678");
        Telefone telefoneAluno1 = new Telefone("1", "14", "33147897", "Celular");


        Aluno aluno1 = new Aluno("1", "Marcos", LocalDate.of(1998, 05, 11), "Masculino", Arrays.asList(enderecoAluno1), Arrays.asList(telefoneAluno1), "teste@teste1.com", "01145461148", "123456");

        Endereco enderecoAluno2 = new Endereco("2L", "25", "Rua B", "Cidade B", "Estado B", "54321-876");
        Telefone telefoneAluno2 = new Telefone("2L", "11", "42553218", "Fixo");


        Aluno aluno2 = new Aluno("2", "Maria", LocalDate.of(1998, 01, 15), "Feminino", Arrays.asList(enderecoAluno2), Arrays.asList(telefoneAluno2), "teste@teste2.com", "01145461448", "123457");

        Endereco enderecoAluno3 = new Endereco("3L", "Rua C", "36", "Cidade C", "Estado C", "98765-432");
        Telefone telefoneAluno3 = new Telefone("3L", "61", "32553255", "Celular");


        Aluno aluno3 = new Aluno("3", "Pedro", LocalDate.of(2024, 05, 28), "Masculino", Arrays.asList(enderecoAluno3), Arrays.asList(telefoneAluno3), "teste@teste3.com", "01145461177", "6798797987");

        // Salve os alunos no banco de dados
        alunoRepository.save(aluno1);
        alunoRepository.save(aluno2);
        alunoRepository.save(aluno3);
    }

    private void carregarCursos() {
        Curso curso1 = new Curso();
        curso1.setTitulo("Curso de Programação");
        curso1.setProgresso(25);
        curso1.setConquistas(Arrays.asList("Conquista 1", "Conquista 2"));
        curso1.setDescricaoResumida("Descrição resumida do curso 1");
        curso1.setDescricaoCompleta("Descrição completa do curso 1");
        curso1.setCor("Azul");
        curso1.setAgrupamento("Agrupamento 1");

        Curso curso2 = new Curso();
        curso2.setTitulo("Curso de Matemática");
        curso2.setProgresso(50);
        curso2.setConquistas(Arrays.asList("Conquista 3", "Conquista 4"));
        curso2.setDescricaoResumida("Descrição resumida do curso 2");
        curso2.setDescricaoCompleta("Descrição completa do curso 2");
        curso2.setCor("Verde");
        curso2.setAgrupamento("Agrupamento 2");

        Curso curso3 = new Curso();
        curso3.setTitulo("Curso de História");
        curso3.setProgresso(75);
        curso3.setConquistas(Arrays.asList("Conquista 5", "Conquista 6"));
        curso3.setDescricaoResumida("Descrição resumida do curso 3");
        curso3.setDescricaoCompleta("Descrição completa do curso 3");
        curso3.setCor("Vermelho");
        curso3.setAgrupamento("Agrupamento 3");

        // Salvar os cursos no MongoDB
        cursoRepository.saveAll(Arrays.asList(curso1, curso2, curso3));
    }


    public void carregarListaUsuario() {

        Usuario usuario1 = new Usuario(
                "1", // ID
                "João", // Nome
                LocalDate.of(1990, 1, 15), // Data de Nascimento
                "Masculino", // Gênero
                "12345", // Matrícula
                new ArrayList<>(), // Lista de endereços (vazia)
                new ArrayList<>(), // Lista de telefones (vazia)
                "joao@email.com", // Email
                "123456789", // CPF
                "senha123", // Senha
                new Perfil("1", "ROLE_ADMIN")
        );


        Usuario usuario2 = new Usuario(
                "2", // ID
                "Maria", // Nome
                LocalDate.of(1985, 4, 10), // Data de Nascimento
                "Feminino", // Gênero
                "54321", // Matrícula
                new ArrayList<>(), // Lista de endereços (vazia)
                new ArrayList<>(), // Lista de telefones (vazia)
                "maria@email.com", // Email
                "987654321", // CPF
                "senha456", // Senha
                new Perfil("2", "ROLE_ALUNO")
        );

        Usuario usuario3 = new Usuario(
                "3", // ID
                "Mega lima", // Nome
                LocalDate.of(1988, 7, 25), // Data de Nascimento
                "Masculino", // Gênero
                "67890", // Matrícula
                new ArrayList<>(), // Lista de endereços (vazia)
                new ArrayList<>(), // Lista de telefones (vazia)
                "carlos@email.com", // Email
                "01156561116", // CPF
                "12345", // Senha
                new Perfil("2", "ROLE_PROFESSOR")

        );


        usuarioService.salvarUsuario(usuario1);
        usuarioService.salvarUsuario(usuario2);
        usuarioService.salvarUsuario(usuario3);



    }


}
