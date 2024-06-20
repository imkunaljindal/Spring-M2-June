package com.example.spring_security_june.config;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        UserDetails user1 = User.withUsername("Rohit")
                .password(passwordEncoder.encode("rohit123"))
                .roles("STUDENT")
                .build();
        UserDetails user2 = User.withUsername("Chitra")
                .password(passwordEncoder.encode("chitra123"))
                .roles("STUDENT")
                .build();
        UserDetails admin1 = User.withUsername("Virat")
                .password(passwordEncoder.encode("virat123"))
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user1,user2,admin1);

        /**
         * DAOAuthentication Provider
         */
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/welcome").permitAll()
                .and()
                .authorizeHttpRequests()
                .requestMatchers("/student/**","/admin").authenticated()
                .and().formLogin().and().build();
    }
}
