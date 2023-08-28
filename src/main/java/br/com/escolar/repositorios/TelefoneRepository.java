package br.com.escolar.repositorios;

import br.com.escolar.colecoes.Telefone;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TelefoneRepository extends MongoRepository<Telefone, Long> {
}
