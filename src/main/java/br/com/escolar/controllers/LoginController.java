package br.com.escolar.controllers;

import br.com.escolar.colecoes.Usuario;
import br.com.escolar.config.EmailService;
import br.com.escolar.config.JwtResponse;
import br.com.escolar.config.JwtTokenUtil;
import br.com.escolar.config.MessageUtil;
import br.com.escolar.dtos.LoginDto;
import br.com.escolar.dtos.SenhaDto;
import br.com.escolar.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/api/logins", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class LoginController {

    @Value("${app.base-url-servidor-react}")
    private String baseUrlServidorReact;
    public static final String CREDENCIAIS_INVALIDAS_OU_USUARIO_NAO_ENCONTRADO = "Credenciais inválidas ou usuário não encontrado";

    private final UsuarioService usuarioService;
    private final JwtTokenUtil jwtTokenUtil;

    private final EmailService emailService;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public LoginController(UsuarioService usuarioService, JwtTokenUtil jwtTokenUtil, EmailService emailService, PasswordEncoder passwordEncoder) {
        this.usuarioService = usuarioService;
        this.jwtTokenUtil = jwtTokenUtil;
        this.emailService = emailService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/autenticacao")
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto) {
        Optional<Usuario> usuarioOptional = usuarioService.login(loginDto);

        if (usuarioOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();
            String token = jwtTokenUtil.generateToken(usuario.getEmail());
            return ResponseEntity.ok(new JwtResponse(token));
        } else {
            return ResponseEntity.badRequest().body(CREDENCIAIS_INVALIDAS_OU_USUARIO_NAO_ENCONTRADO);
        }
    }

    @GetMapping("/esqueci-senha")
    public ResponseEntity<String> esqueciMinhaSenha(@RequestParam String email) {
        String tokenDefinicaoSenha = jwtTokenUtil.generateToken(email);
        emailService.enviarEmailComToken(email, tokenDefinicaoSenha);
        return ResponseEntity.ok("Email de redefinição de senha enviado com sucesso.");
    }

    @GetMapping("/redefinir-senha")
    public ResponseEntity<String> redefinirSenha(@RequestParam("token") String token) {
        if (token == null || !jwtTokenUtil.validateToken(token, jwtTokenUtil.extractUsername(token))) {
            String invalidTokenUrl = baseUrlServidorReact + "/token-invalido";
            return ResponseEntity.status(HttpStatus.FOUND)
                    .header("Location", invalidTokenUrl)
                    .body("Redirecionando para a página de token inválido...");
        }

        String email = jwtTokenUtil.extractUsername(token);
        Optional<Usuario> usuarioOptional = usuarioService.findByEmail(email);

        if (usuarioOptional.isPresent()) {
            String redirectUrl = baseUrlServidorReact + "/alterar-minha-senha";
            return ResponseEntity.status(HttpStatus.FOUND)
                    .header("Location", redirectUrl)
                    .body("Redirecionando para a página de alteração de senha...");
        }

        String invalidTokenUrl = baseUrlServidorReact + "/token-invalido";
        return ResponseEntity.status(HttpStatus.FOUND)
                .header("Location", invalidTokenUrl)
                .body("Redirecionando para a página de token inválido...");
    }

    @PutMapping("/alterar-senha")
    public ResponseEntity<String> alterarSenha(@RequestBody SenhaDto senhaDto) {
        Optional<Usuario> usuarioOptional = usuarioService.findByEmail(senhaDto.getEmail());

        if (usuarioOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();

            if (!passwordEncoder.matches(senhaDto.getSenhaAtual(), usuario.getSenha())) {
                return ResponseEntity.badRequest().body(MessageUtil.getMessage("senha.incorreta"));
            }

            if (!senhaDto.getNovaSenha().equals(senhaDto.getConfirmarSenha())) {
                return ResponseEntity.badRequest().body(MessageUtil.getMessage("nova.senha.confirmacao"));
            }

            usuario.setSenha(passwordEncoder.encode(senhaDto.getNovaSenha()));
            usuarioService.salvarUsuario(usuario);
            return ResponseEntity.ok(MessageUtil.getMessage("senha.alterada.sucesso"));
        }

        return ResponseEntity.badRequest().body(MessageUtil.getMessage("falha.alterar.senha"));
    }



}
