package br.com.escolar.repositorios;

import br.com.escolar.colecoes.Aluno;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AlunoRepository extends MongoRepository<Aluno, Long> {
}
