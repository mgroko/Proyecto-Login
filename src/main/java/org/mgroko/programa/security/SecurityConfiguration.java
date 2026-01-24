package org.mgroko.programa.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((authorizeRequests -> authorizeRequests
                .requestMatchers("/login", "/registro").permitAll()
                .requestMatchers("/paginaAdmin").hasRole("ADMIN")
                .requestMatchers("/usuario").hasRole("USER_ROLE")
                .anyRequest().authenticated()));
        return http.build();
    }

}
