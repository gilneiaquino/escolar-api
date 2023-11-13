package br.com.escolar.repositorios;

import br.com.escolar.colecoes.Perfil;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PerfilRepository extends MongoRepository<Perfil, Long> {


}
