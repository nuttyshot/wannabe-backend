package wannabe.backend.config.security;

import java.util.ArrayList;
import java.util.List;
import lombok.val;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer.FrameOptionsConfig;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Bean
  public AuthenticationProvider authenticationManager() {
    DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
    authenticationProvider.setUserDetailsService(userDetailsService());
    authenticationProvider.setPasswordEncoder(passwordEncoder());
    return authenticationProvider;
  }

  private UserDetailsService userDetailsService() {
    return memberNo -> {
      final String USER_ROLE = "ROLE_USER";
      val authorities = new ArrayList<GrantedAuthority>();
      authorities.add(new SimpleGrantedAuthority(USER_ROLE));
      return new User(memberNo, "", authorities);
    };
  }

  private PasswordEncoder passwordEncoder() {
    return new CustomPasswordEncoder();
  }

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

  private static class CustomPasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence rawPassword) {
      return "";
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
      return true;
    }
  }
}
