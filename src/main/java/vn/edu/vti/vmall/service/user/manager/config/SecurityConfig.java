package vn.edu.vti.vmall.service.user.manager.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import vn.edu.vti.vmall.security.filter.JwtTokenFilter;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {
  private final JwtTokenFilter jwtTokenFilter;
  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.csrf(AbstractHttpConfigurer::disable);
    http.authorizeHttpRequests(authorizationManagerRequestMatcherRegistry ->
        authorizationManagerRequestMatcherRegistry
            .requestMatchers(
                "/api/v1/auth/**",
                "/api/v1/internal/**"
            )
            .permitAll()
            .anyRequest()
            .authenticated()
    ).addFilterBefore(
        jwtTokenFilter,
        BasicAuthenticationFilter.class
    );
    return http.build();
  }
}
