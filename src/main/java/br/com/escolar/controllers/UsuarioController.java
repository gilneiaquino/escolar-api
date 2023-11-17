package br.com.escolar.controllers;

import br.com.escolar.colecoes.Usuario;
import br.com.escolar.config.JwtResponse;
import br.com.escolar.config.JwtTokenUtil;
import br.com.escolar.dtos.UsuarioDto;
import br.com.escolar.services.UsuarioService;
import br.com.escolar.services.UsuarioService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
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
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/cadastro")
    public ResponseEntity<Usuario> criarUsuario(@Valid @RequestBody Usuario usuario) {
        Usuario novoUsuario = usuarioService.salvarUsuario(usuario);
        return new ResponseEntity<>(novoUsuario, HttpStatus.CREATED);
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
            @RequestParam(name = "nome", defaultValue = "") String nome,
            @RequestParam(name = "cpf", defaultValue = "") String cpf,
            @RequestParam(name = "matricula", defaultValue = "") String matricula) {

        List<Usuario> usuarios = usuarioService.consultarUsuarios(nome, cpf, matricula);

        return usuarios.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(usuarios);
    }


    @PostMapping("/autenticacao")
    public ResponseEntity<?> login(@Valid @RequestBody UsuarioDto usuarioDto) {
        Optional<Usuario> usuarioOptional = usuarioService.login(usuarioDto);

        if (usuarioOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();
            String token = jwtTokenUtil.generateToken(usuario.getEmail());

            return ResponseEntity.ok(new JwtResponse(token));
        } else {
            return ResponseEntity.badRequest().body("Credenciais inválidas ou usuário não encontrado");
        }
    }

}
