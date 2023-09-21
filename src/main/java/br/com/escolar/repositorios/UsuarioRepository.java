package br.com.escolar.repositorios;

import br.com.escolar.colecoes.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {
    Usuario findByEmail(String email);
}
