package br.com.escolar.repositorios;

import br.com.escolar.colecoes.Endereco;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EnderecoRepository extends MongoRepository<Endereco, String> {
}

