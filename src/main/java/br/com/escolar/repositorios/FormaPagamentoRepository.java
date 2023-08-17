package br.com.escolar.repositorios;

import br.com.escolar.colecoes.FormaPagamento;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FormaPagamentoRepository extends MongoRepository<FormaPagamento, String> {
}
