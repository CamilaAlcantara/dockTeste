package com.api.dock.security;

import com.api.dock.service.UserDatailsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@EnableWebSecurity
@Log4j2
@EnableGlobalMethodSecurity(prePostEnabled = true)
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDatailsService userDatailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       http.csrf().disable()
//               csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
//               .and()
               .authorizeRequests()
               .anyRequest()
               .authenticated()
               .and()
               .formLogin()
               .and()
               .httpBasic();
     }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//        log.info("Passoword encoded {}",passwordEncoder.encode("academy") );
//        auth.inMemoryAuthentication()
//                .withUser("camila")
//                .password(passwordEncoder.encode("26camila"))
//                .roles("USER","ADMIN");
        auth.userDetailsService(userDatailsService).passwordEncoder(passwordEncoder);
    }
}
