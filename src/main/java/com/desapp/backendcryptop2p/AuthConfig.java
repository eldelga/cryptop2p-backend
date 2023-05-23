package com.desapp.backendcryptop2p;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@EnableWebSecurity
public class AuthConfig {

    @Configuration
    public static class SecurityConfiguration extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            // Deshabilitar CSRF
            http.csrf().disable();
            http.headers().frameOptions().disable();
        }

        // Otras configuraciones de seguridad aquí
    }
}


