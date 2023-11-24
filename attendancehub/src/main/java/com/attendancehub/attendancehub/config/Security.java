package com.attendancehub.attendancehub.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.attendancehub.attendancehub.service.service;

@Configuration
public class Security {

    @Autowired
    private service userService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder()
    {
     return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider()
    { 
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userService);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception 
    {
            http.authorizeHttpRequests((authz) -> authz
                .anyRequest().authenticated().requestMatchers(
                    "/registration**",
                    "/js/**",
                    "/css/**",
                    "/img/**").permitAll().anyRequest().authenticated())
                    .formLogin(formLogin -> formLogin.loginPage("/login").permitAll())
                    .logout(logout -> logout.invalidateHttpSession(true).clearAuthentication(true).logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                    .logoutSuccessUrl("/login?logout").permitAll());

                    return http.build();
    }

}

