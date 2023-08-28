package br.com.escolar.repositorios;

import br.com.escolar.colecoes.Mensalidade;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MensalidadeRepository extends MongoRepository<Mensalidade, Long> {
}
