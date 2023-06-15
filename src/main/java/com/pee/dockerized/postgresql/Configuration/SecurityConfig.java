package com.pee.dockerized.postgresql.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {
    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration authenticationConfiguration)
            throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/login/**").permitAll()
                .antMatchers("/dron/").permitAll()
                .antMatchers("/coordenadas/new","/coordenadas/").hasAnyRole("USER", "ADMIN")
                .antMatchers("/dron/**","/tipodron/**","/coordenadas/**").hasAnyRole("ADMIN")
                .antMatchers("/webjars/**", "/css/**", "/img/**").permitAll()
                .anyRequest().hasRole("ADMIN")
                .and().formLogin().permitAll().defaultSuccessUrl("/login/")
                .and().logout().permitAll().logoutSuccessUrl("/login/")
                .and().exceptionHandling().accessDeniedPage("/accessError");
        return http.build();
    }
}