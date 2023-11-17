package br.com.escolar.config;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender javaMailSender;

    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void enviarEmailComToken(String destinatario, String token) {
        String assunto = "Recuperação de Senha - Token de Verificação";
        String corpo = construirCorpoEmail(token);

        enviarEmail(destinatario, assunto, corpo);
    }

    private String construirCorpoEmail(String token) {
        StringBuilder corpo = new StringBuilder();
        corpo.append("Olá,\n\n")
                .append("Você solicitou a recuperação de senha. Utilize o seguinte token para redefinir sua senha: ")
                .append(token).append("\n\n")
                .append("Atenciosamente,\n")
                .append("Equipe Escolar");

        return corpo.toString();
    }

    private void enviarEmail(String destinatario, String assunto, String corpo) {
        SimpleMailMessage mensagem = new SimpleMailMessage();
        mensagem.setTo(destinatario);
        mensagem.setSubject(assunto);
        mensagem.setText(corpo);

        javaMailSender.send(mensagem);
    }
}
