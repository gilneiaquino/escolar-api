package br.com.escolar.controllers;

public class AlunoControllerTest {
//
//    private MockMvc mockMvc;
//
//    @InjectMocks
//    private AlunoController alunoController;
//
//    @Mock
//    private AlunoService alunoService;
//
//    @BeforeEach
//    public void setUp() {
//        MockitoAnnotations.initMocks(this);
//        mockMvc = MockMvcBuilders.standaloneSetup(alunoController).build();
//    }
//
//    @Test
//    public void testCriarAluno() throws Exception {
//        Aluno aluno = new Aluno();
//        aluno.setNome("Maria");
//
//        when(alunoService.salvarAluno(any(Aluno.class))).thenReturn(aluno);
//
//        mockMvc.perform(post("/api/alunos")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(new ObjectMapper().writeValueAsString(aluno)))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.nome").value("Maria"));
//    }
//
//    @Test
//    public void testListarAlunos() throws Exception {
//        List<Aluno> alunos = new ArrayList<>();
//        alunos.add(new Aluno());
//        alunos.add(new Aluno());
//
//        when(alunoService.listarTodosAlunos()).thenReturn(alunos);
//
//        mockMvc.perform(get("/api/alunos")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.length()").value(2));
//    }
//
//    @Test
//    public void testBuscarAlunoPorId() throws Exception {
//        String id = "1L";
//        Aluno aluno = new Aluno();
//        aluno.setId(id);
//
//        when(alunoService.buscarAlunoPorId(id)).thenReturn(aluno);
//
//        mockMvc.perform(get("/api/alunos/{id}", id)
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.id").value(id));
//    }
//
//    @Test
//    public void testExcluirAluno() throws Exception {
//        String id = "1L";
//
//        mockMvc.perform(delete("/api/alunos/{id}", id)
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk());
//
//        verify(alunoService, times(1)).excluirAluno(id);
//    }
}


