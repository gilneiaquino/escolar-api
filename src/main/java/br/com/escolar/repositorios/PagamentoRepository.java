package br.com.escolar.repositorios;

import br.com.escolar.colecoes.Pagamento;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PagamentoRepository extends MongoRepository<Pagamento, String> {
}
