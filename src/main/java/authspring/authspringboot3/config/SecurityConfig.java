package authspring.authspringboot3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import authspring.authspringboot3.Jwt.JwtAuthenticationFilter;

import static authspring.authspringboot3.auth.User.Permission.*;
import static authspring.authspringboot3.auth.User.Role.*;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.security.config.Customizer.withDefaults;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
public class SecurityConfig {
    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final AuthenticationProvider authProvider;

    @Bean
    public SecurityFilterChain securityfilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(authRequest -> authRequest
                        .requestMatchers("/auth/**")
                        .permitAll()
                        .requestMatchers("/api/v1/management/**").hasAnyRole(ADMIN.name(),MANAGER.name())


                        .requestMatchers(GET,"/api/v1/management/**").hasAnyAuthority(ADMIN_READ.name(),MANAGER_READ.name())
                        .requestMatchers(HttpMethod.POST,"/api/v1/management/**").hasAnyAuthority(ADMIN_CREATE.name(),MANAGER_CREATE.name())
                        .requestMatchers(HttpMethod.PUT,"/api/v1/management/**").hasAnyAuthority(ADMIN_UPDATE.name(),MANAGER_UPDATE.name())
                        .requestMatchers(HttpMethod.DELETE,"/api/v1/management/**").hasAnyAuthority(ADMIN_DELETE.name(),MANAGER_DELETE.name())


                        .requestMatchers("/api/v1/admin/**").hasRole(ADMIN.name())

                        .requestMatchers(GET,"/api/v1/admin/**").hasAnyAuthority(ADMIN_READ.name())
                        .requestMatchers(HttpMethod.POST,"/api/v1/admin/**").hasAnyAuthority(ADMIN_CREATE.name())
                        .requestMatchers(HttpMethod.PUT,"/api/v1/admin/**").hasAnyAuthority(ADMIN_UPDATE.name())
                        .requestMatchers(HttpMethod.DELETE,"/api/v1/admin/**").hasAnyAuthority(ADMIN_DELETE.name())


                        .anyRequest()
                        .authenticated())

                .sessionManagement(
                        sessionManager -> sessionManager
                                .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

}
