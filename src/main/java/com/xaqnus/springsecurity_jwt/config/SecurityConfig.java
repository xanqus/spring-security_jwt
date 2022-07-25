package com.xaqnus.springsecurity_jwt.config;

import com.xaqnus.springsecurity_jwt.filter.MyFilter3;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final CorsFilter corsFilter;

  @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return
                http
                .addFilterBefore(new MyFilter3(), UsernamePasswordAuthenticationFilter.class) //Security Config에 Filter거는 방법
                .csrf()
                .disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                        .addFilter(corsFilter)// @CrossOrigin 어노테이션을 컨트롤러에 걸면 인증이 없을때 작동함, 인증이 있을때는 시큐리티 필터에 cors설정을 걸어줘야함
                        .formLogin()
                        .disable()
                        .httpBasic()
                        .disable()
                        .authorizeRequests()
                        .antMatchers("/api/v1/user/**")
                        .access("hasRole('ROLE_USER') or hasRole('ROLE_MANAGER') or hasRole('ROLE_ADMIN')")
                        .antMatchers("/api/v1/manager/**")
                        .access("hasRole('ROLE_MANAGER') or hasRole('ROLE_ADMIN')")
                        .antMatchers("/api/v1/admin/**")
                        .access("hasRole('ROLE_ADMIN')")
                        .anyRequest()
                        .permitAll()
                        .and()
                .build();
    }
}
