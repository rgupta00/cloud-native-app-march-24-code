package com.bankapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity(debug = true)
public class SecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
    //authorization
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{
//        http.csrf(AbstractHttpConfigurer::disable)
//                .authorizeHttpRequests(registry->{
//                    registry.requestMatchers("/admin/**").hasAnyRole("ADMIN")
//                            .requestMatchers("/mgr/**").hasAnyRole("ADMIN","MGR")
//                            .requestMatchers("/clerk/**").hasAnyRole("ADMIN","MGR","CLERK")
//                            .requestMatchers("/home/**").permitAll()
//                            .anyRequest().authenticated();
//                }).httpBasic(Customizer.withDefaults())
//                .sessionManagement(configure->{
//                    configure.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//                });
//        return http.build();
        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(
                        registry-> registry.requestMatchers("/admin/**").hasAnyRole("ADMIN")
                                .requestMatchers("/mgr/**").hasAnyRole("ADMIN","MGR")
                                .requestMatchers("/clerk/**").hasAnyRole("ADMIN","MGR","CLERK")
                                .requestMatchers("/home/**").permitAll()
                )
                .httpBasic(Customizer.withDefaults())
//                .formLogin(Customizer.withDefaults())
                .sessionManagement(configre->configre.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.build();
    }

}
