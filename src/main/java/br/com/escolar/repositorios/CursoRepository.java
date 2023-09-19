package br.com.escolar.repositorios;

import br.com.escolar.colecoes.Curso;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CursoRepository extends MongoRepository<Curso, String> {
    // Métodos de consulta personalizados, se necessário
}