package br.com.escolar.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers("/api/usuarios/login").permitAll()
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

}
