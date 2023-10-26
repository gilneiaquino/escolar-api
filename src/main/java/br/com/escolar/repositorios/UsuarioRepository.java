package br.com.escolar.repositorios;

import br.com.escolar.colecoes.Aluno;
import br.com.escolar.colecoes.Usuario;
import br.com.escolar.dtos.UsuarioDto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {
    Usuario findByEmail(String email);

    @Query("SELECT a FROM Aluno a " +
            "WHERE (:nome IS NULL OR a.nome = :nome) " +
            "AND (:cpf IS NULL OR a.cpf = :cpf) " +
            "AND (:matricula IS NULL OR a.matricula = :matricula)")
    List<Usuario> buscarUsuariosPorNomeCpfMatricula(String nome, String cpf, String matricula);

    Usuario findByCpfAndSenha(String cpf, String senha);

    Optional<Usuario> findByNome(String nomeUsuario);


}
