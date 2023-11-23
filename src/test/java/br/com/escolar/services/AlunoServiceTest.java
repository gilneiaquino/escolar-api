package br.com.escolar.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlunoServiceTest {
/*
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
        String id = "1L";
        Aluno aluno = new Aluno();
        aluno.setId(id);
        when(alunoRepository.findById(id)).thenReturn(Optional.of(aluno));

        Aluno resultado = alunoService.buscarAlunoPorId(id);

        assertEquals(id, resultado.getId());
    }

    @Test
    public void testExcluirAluno() {
        String id = "1L";

        alunoService.excluirAluno(id);

        verify(alunoRepository, times(1)).deleteById(id);
    }*/
}
