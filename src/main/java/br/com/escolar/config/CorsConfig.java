package br.com.escolar.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/alunos") // Defina o caminho que deseja permitir
                .allowedOrigins("http://localhost:3000") // Defina a origem permitida (seu aplicativo React)
                .allowedMethods("GET", "POST", "PUT", "DELETE"); // Defina os métodos HTTP permitidos
    }
}
