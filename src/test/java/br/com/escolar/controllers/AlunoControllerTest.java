package br.com.escolar.controllers;
import br.com.escolar.colecoes.Aluno;
import br.com.escolar.services.AlunoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class AlunoControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private AlunoController alunoController;

    @Mock
    private AlunoService alunoService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(alunoController).build();
    }

    @Test
    public void testCriarAluno() throws Exception {
        Aluno aluno = new Aluno();
        aluno.setNome("Maria");

        when(alunoService.salvarAluno(any(Aluno.class))).thenReturn(aluno);

        mockMvc.perform(post("/api/alunos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(aluno)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("Maria"));
    }

    @Test
    public void testListarAlunos() throws Exception {
        List<Aluno> alunos = new ArrayList<>();
        alunos.add(new Aluno());
        alunos.add(new Aluno());

        when(alunoService.listarTodosAlunos()).thenReturn(alunos);

        mockMvc.perform(get("/api/alunos")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2));
    }

    @Test
    public void testBuscarAlunoPorId() throws Exception {
        Long id = 1L;
        Aluno aluno = new Aluno();
        aluno.setId(id);

        when(alunoService.buscarAlunoPorId(id)).thenReturn(aluno);

        mockMvc.perform(get("/api/alunos/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id));
    }

    @Test
    public void testExcluirAluno() throws Exception {
        Long id = 1L;

        mockMvc.perform(delete("/api/alunos/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(alunoService, times(1)).excluirAluno(id);
    }
}


