package com.dataart.retman;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private static final String USER = "USER";
    private static final String ADMIN = "ADMIN";
    private static final String ROLE_TO_SEE_SECRET_MESSAGE = "SECRET_ROLE";
    private static final String ROLE_TO_SEE_THE_PIC = "PAINTER_ROLE";

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("dretman").password("123").roles(USER)
                .and().withUser("admin").password("123").roles(USER, ADMIN)
                .and().withUser("sec").password("123").roles(USER, ROLE_TO_SEE_SECRET_MESSAGE)
                .and().withUser("habuma").password("123").roles(USER);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/spitter/**").hasRole(USER)
                .antMatchers("/picture").access("isAuthenticated() and principal.username=='habuma'")
//                .antMatchers(HttpMethod.POST, "/spittles/**").hasRole(ADMIN)
//                .anyRequest().permitAll();
//                .and()
//                .requiresChannel().antMatchers("/spittles/**").requiresSecure()
                .and().formLogin().loginPage("/loginForm")
                .and().logout().logoutUrl("/logoutUrl").logoutSuccessUrl("/");
        http.csrf().disable();
    }
}
