package br.com.escolar.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.csrf((csrf) -> csrf
                .ignoringRequestMatchers("/api/usuarios/autenticacao")
                .ignoringRequestMatchers("/api/usuarios/cadastro")

        );
        http.authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers("/api/usuarios/autenticacao").permitAll()
                        .requestMatchers("/api/usuarios/cadastro").permitAll()
                        .anyRequest().authenticated()
                ).formLogin((form) -> form
                        .loginPage("http://localhost:3000/login")
                        .defaultSuccessUrl("/", true)
                        .defaultSuccessUrl("http://localhost:3000/", true)
                        .failureUrl("/login-error")
                        .permitAll())
                .logout((logout) -> logout
                        .logoutSuccessUrl("/").permitAll()
                        .deleteCookies("JSESSIONID")
                )
                .exceptionHandling((ex) -> ex
                        .accessDeniedPage("/negado")
                );

        return http.build();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:3000"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

}
