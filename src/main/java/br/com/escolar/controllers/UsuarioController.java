package br.com.escolar.controllers;

import br.com.escolar.colecoes.Usuario;
import br.com.escolar.dtos.UsuarioDto;
import br.com.escolar.services.UsuarioService;
import br.com.escolar.services.UsuarioService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/usuarios", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class UsuarioController {

    private static final Logger logger = LoggerFactory.getLogger(UsuarioController.class);


    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public Usuario criarUsuario(@Valid @RequestBody Usuario usuario) {
        return usuarioService.salvarUsuario(usuario);
    }

    @GetMapping
    public List<Usuario> listarUsuarios() {
        return usuarioService.listarTodosUsuarios();
    }

    @GetMapping("/recuperar/{id}")
    public Usuario recuperarUsuarioPorId(@PathVariable String id) {
        return usuarioService.buscarUsuarioPorId(id);
    }

    @PutMapping("/{id}")
    public Usuario atualizarUsuario(@PathVariable String id, @RequestBody Usuario usuario) {
        usuario.setId(id);
        return usuarioService.salvarUsuario(usuario);
    }

    @DeleteMapping("/{id}")
    public void excluirUsuario(@PathVariable String id) {
        usuarioService.excluirUsuario(id);
    }

    @GetMapping("/consultar")
    public ResponseEntity<List<Usuario>> consultar(
            @RequestParam(name = "nome", required = false) String nome,
            @RequestParam(name = "cpf", required = false) String cpf,
            @RequestParam(name = "matricula", required = false) String matricula) {

        if (cpf == null) {
            cpf = ""; // Defina um valor padrão ou deixe em branco, dependendo dos requisitos.
        }

        if (matricula == null) {
            matricula = ""; // Defina um valor padrão ou deixe em branco, dependendo dos requisitos.
        }

        List<Usuario> usuarios = usuarioService.consultarUsuarios(nome, cpf, matricula);

        if (usuarios.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(usuarios);
        }
    }

    @PostMapping("/autenticacao")
    public Usuario login(UsuarioDto usuarioDto) {
        Optional<Usuario> usuarioOptional = usuarioService.login(usuarioDto);

        if (usuarioOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();
            System.out.println(usuario.getLogin());
        }
        return null;
    }
}
