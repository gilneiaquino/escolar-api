package br.com.escolar.services;

import br.com.escolar.colecoes.Aluno;
import br.com.escolar.repositorios.AlunoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class AlunoServiceTest {

    @InjectMocks
    private AlunoService alunoService;

    @Mock
    private AlunoRepository alunoRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSalvarAluno() {
        Aluno aluno = new Aluno();
        aluno.setNome("João");
        when(alunoRepository.save(aluno)).thenReturn(aluno);

        Aluno resultado = alunoService.salvarAluno(aluno);

        assertEquals(aluno.getNome(), resultado.getNome());
    }

    @Test
    public void testListarTodosAlunos() {
        List<Aluno> alunos = new ArrayList<>();
        alunos.add(new Aluno());
        alunos.add(new Aluno());
        when(alunoRepository.findAll()).thenReturn(alunos);

        List<Aluno> resultado = alunoService.listarTodosAlunos();

        assertEquals(2, resultado.size());
    }

    @Test
    public void testBuscarAlunoPorId() {
        Long id = 1L;
        Aluno aluno = new Aluno();
        aluno.setId(id);
        when(alunoRepository.findById(id)).thenReturn(Optional.of(aluno));

        Aluno resultado = alunoService.buscarAlunoPorId(id);

        assertEquals(id, resultado.getId());
    }

    @Test
    public void testExcluirAluno() {
        Long id = 1L;

        alunoService.excluirAluno(id);

        verify(alunoRepository, times(1)).deleteById(id);
    }
}
