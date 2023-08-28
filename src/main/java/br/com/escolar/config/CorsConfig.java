package br.com.escolar.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Defina o caminho para permitir todas as URLs
                .allowedOrigins("*") // Permita todas as origens (qualquer origem)
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Defina os métodos HTTP permitidos
                .allowedHeaders("*"); // Permita todos os cabeçalhos HTTP
    }
}
