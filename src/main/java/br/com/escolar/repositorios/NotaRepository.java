package br.com.escolar.repositorios;

import br.com.escolar.colecoes.Nota;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NotaRepository extends MongoRepository<Nota, Long> {
}