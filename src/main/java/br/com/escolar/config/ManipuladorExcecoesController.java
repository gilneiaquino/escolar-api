package br.com.escolar.config;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.MethodArgumentNotValidException;

@ControllerAdvice
public class ManipuladorExcecoesController {

    public static final String ERRO_DE_VALIDACAO = "Erro de validação: ";

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> manipularExcecaoDeValidacao(MethodArgumentNotValidException ex) {
        return ResponseEntity.badRequest().body(ERRO_DE_VALIDACAO + ex.getMessage());
    }
}
