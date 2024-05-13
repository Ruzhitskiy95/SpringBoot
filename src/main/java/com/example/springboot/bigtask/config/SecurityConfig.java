package com.example.springboot.bigtask.config;

import com.example.springboot.bigtask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final UserService userService;

    private final JwtAuthFilter jwtAuthFilter;

    @Autowired
    public SecurityConfig (UserService userService, JwtAuthFilter jwtAuthFilter){
        this.userService = userService;
        this.jwtAuthFilter = jwtAuthFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth->auth
                .requestMatchers("/loginToken").authenticated()
                        .requestMatchers("/login").authenticated()
                        .requestMatchers("/engineer").hasRole("Engineer")
                        .requestMatchers("/admin/**").hasRole("Admin")
                        .requestMatchers("/manager/**").hasRole("Manager")
                        .requestMatchers("/swagger-ui/**").permitAll()
                        .anyRequest().authenticated())
                .userDetailsService(userService)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .httpBasic(Customizer.withDefaults())
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    public UserDetailsService users () {
//        UserDetails admin = User.builder()
//                .username("Alex")
//                .password(passwordEncoder().encode("Alex"))
//                .roles("Admin")
//                .build();
//        UserDetails managerOne = User.builder()
//                .username("Tom")
//                .password(passwordEncoder().encode("Tom"))
//                .roles("Manager")
//                .build();
//        UserDetails managerTwo = User.builder()
//                .username("Nick")
//                .password(passwordEncoder().encode("Nick"))
//                .roles("Manager")
//                .build();
//        UserDetails engineer  = User.builder()
//                .username("Rikki")
//                .password(passwordEncoder().encode("Rikki"))
//                .roles("Engineer")
//                .build();
//        return new InMemoryUserDetailsManager(admin,managerOne,managerTwo, engineer);
//    }

    @Bean
    public AuthenticationProvider authenticationProvider (){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager (AuthenticationConfiguration config) throws Exception{

        return config.getAuthenticationManager();
    }

}
