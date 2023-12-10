package com.example.ProyectoCENS.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfiguration {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(authorizeRequests -> authorizeRequests
                        .antMatchers(
                                "/registro/**", "/js/**", "/resetPassword/**",
                                "/css/**",
                                "/img/**")
                        .permitAll()
                        .antMatchers("/admin").hasRole("ADMIN") // Exigir rol ROLE_ADMIN para acceder a /admin
                        .antMatchers("/guardarUsuario").hasRole("ADMIN") // Exigir rol ROLE_ADMIN para acceder a /admin
                        .antMatchers("/listar").hasRole("ADMIN") // Exigir rol ROLE_ADMIN para acceder a /admin
                        .antMatchers("/administrarEmpresas").hasRole("ADMIN")
                        .antMatchers("/listarEmpresas").hasRole("ADMIN")
                        .anyRequest().authenticated())
                .formLogin(login -> login
                        .loginPage("/login")
                        .permitAll())
                .logout(logout -> logout
                        .invalidateHttpSession(true)
                        .clearAuthentication(true)
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        .logoutSuccessUrl("/login?logout")
                        .permitAll());

        http.headers(headers -> headers.frameOptions().sameOrigin());

        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().antMatchers("/images/**", "/js/**", "/img/**");
    }

}