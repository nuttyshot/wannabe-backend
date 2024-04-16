package wannabe.backend.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer.FrameOptionsConfig;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity)
      throws Exception {
    return httpSecurity
        .csrf(CsrfConfigurer::disable)
        .authorizeHttpRequests(
            requestMatchers -> requestMatchers
                .anyRequest()
                .permitAll())
        .headers(headersConfigurer -> headersConfigurer
            .frameOptions(FrameOptionsConfig::disable))
        .build();
  }
}
