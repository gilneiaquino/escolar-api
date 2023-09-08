package br.com.escolar.repositorios;

import br.com.escolar.colecoes.Aluno;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AlunoRepository extends MongoRepository<Aluno, String> {


    @Query("SELECT a FROM Aluno a " +
            "WHERE (:nome IS NULL OR a.nome = :nome) " +
            "AND (:cpf IS NULL OR a.cpf = :cpf) " +
            "AND (:matricula IS NULL OR a.matricula = :matricula)")
    List<Aluno> buscarAlunosPorNomeCpfMatricula(String nome, String cpf, String matricula);

}
