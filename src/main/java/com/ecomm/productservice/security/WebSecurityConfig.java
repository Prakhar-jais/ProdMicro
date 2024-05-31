package com.ecomm.productservice.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig {
    

    public SecurityFilterChain securityWebFilterChain(HttpSecurity http)throws Exception{
        http
            .authorizeHttpRequests(authorizeRequests -> 
                authorizeRequests.anyRequest().authenticated())
            .oauth2ResourceServer(oauth2 -> 
                oauth2.jwt(jwtConfigurer -> {})
            );

            return http.build();

    }
}
