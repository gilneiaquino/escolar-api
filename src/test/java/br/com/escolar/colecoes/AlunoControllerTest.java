package br.com.escolar.colecoes;

import br.com.escolar.colecoes.Aluno;
import br.com.escolar.colecoes.Endereco;
import br.com.escolar.colecoes.Telefone;
import br.com.escolar.repositorios.AlunoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;



import java.util.Arrays;

@SpringBootTest(classes={br.com.escolar.colecoes.Aluno.class})
@AutoConfigureMockMvc
@RequestMapping("/api/alunos")
public class AlunoControllerTest {

    @Autowired
    MockMvc mockMvc;

    private ObjectMapper objectMapper = new ObjectMapper();

    @MockBean
    AlunoRepository alunoRepository;
/*
    @BeforeEach
    public void configurar() {
        // Crie alguns alunos de teste para usar nos testes.
        Aluno aluno1 = new Aluno(1L, "João", "1990-01-01", "Masculino", new Endereco(1L, "Rua 123", "123", "Cidade A", "Estado A", "12345"), Arrays.asList(new Telefone(1L, "123456789", "Celular")));
        Aluno aluno2 = new Aluno(2L, "Maria", "1995-02-02", "Feminino", new Endereco(2L, "Rua 456", "456", "Cidade B", "Estado B", "67890"), Arrays.asList(new Telefone(2L, "987654321", "Fixo")));

        alunoRepository.save(aluno1);
        alunoRepository.save(aluno2);
    }

    @Test
    public void deveCriarUmAluno() throws Exception {
        Aluno aluno = new Aluno(1L, "João", "1990-01-01", "Masculino", new Endereco(1L, "Rua 123", "123", "Cidade A", "Estado A", "12345"), new ArrayList<>());

        Mockito.when(alunoRepository.save(ArgumentMatchers.any(Aluno.class))).thenReturn(aluno);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/alunos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(aluno)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.nome").value("João"));
    }


   @Test
    public void deveListarTodosOsAlunos() throws Exception {
        List<Aluno> alunos = new ArrayList<>();
        alunos.add(new Aluno(1L, "João", "1990-01-01", "Masculino", new Endereco(1L, "Rua 123", "123", "Cidade A", "Estado A", "12345"), new ArrayList<>()));
        alunos.add(new Aluno(2L, "Maria", "1995-02-02", "Feminino", new Endereco(2L, "Rua 456", "456", "Cidade B", "Estado B", "67890"), new ArrayList<>()));

       Mockito.when(alunoRepository.findAll()).thenReturn(alunos);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/alunos"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$").isArray())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].nome").value("João"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].nome").value("Maria"));
    }

    @Test
    public void deveBuscarUmAlunoPorId() throws Exception {
        Aluno aluno = new Aluno(1L, "João", "1990-01-01", "Masculino", new Endereco(1L, "Rua 123", "123", "Cidade A", "Estado A", "12345"), new ArrayList<>());

        Mockito.when(alunoRepository.findById(1L)).thenReturn(Optional.of(aluno));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/alunos/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.nome").value("João"));
    }

    @Test
    public void deveAtualizarUmAlunoPorId() throws Exception {
        Aluno aluno = new Aluno(1L, "João", "1990-01-01", "Masculino", new Endereco(1L, "Rua 123", "123", "Cidade A", "Estado A", "12345"), new ArrayList<>());

        Mockito.when(alunoRepository.save(ArgumentMatchers.any(Aluno.class))).thenReturn(aluno);
        Mockito.when(alunoRepository.findById(1L)).thenReturn(Optional.of(aluno));

        mockMvc.perform(MockMvcRequestBuilders.put("/api/alunos/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(aluno)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.nome").value("João"));
    }

    @Test
    public void deveExcluirUmAlunoPorId() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/alunos/1"))
                .andExpect(MockMvcResultMatchers.status().isNoContent());

        Mockito.verify(alunoRepository, Mockito.times(1)).deleteById(1L);
    }*/

}
