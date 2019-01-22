package com.example.bankbackend.Configurations;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@EnableOAuth2Sso
@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
            .csrf()
            .disable()
            .antMatcher("/**")
            .authorizeRequests()
            .antMatchers("/", "/index.html")
            .permitAll()
            .anyRequest()
            .fullyAuthenticated()
            .and()
            .logout()
            .logoutSuccessUrl("/api/logout")
            .permitAll();


  }
}
