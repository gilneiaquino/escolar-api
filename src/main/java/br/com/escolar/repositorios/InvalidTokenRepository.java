package br.com.escolar.repositorios;

import br.com.escolar.colecoes.InvalidToken;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InvalidTokenRepository extends MongoRepository<InvalidToken, String> {
    InvalidToken findByToken(String token);
}
