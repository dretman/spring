package com.dataart.retman;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private static final String USER = "USER";
    private static final String ADMIN = "ADMIN";

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("dretman").password("12345").roles(USER)
                .and().withUser("admin").password("12345").roles(USER, ADMIN);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/spitter/**").hasRole(USER)
                .antMatchers(HttpMethod.POST, "/spittles/**").hasRole(ADMIN)
//                .anyRequest().permitAll();
//                .and()
//                .requiresChannel().antMatchers("/spittles/**").requiresSecure()
                .and().formLogin().loginPage("/loginForm")
                .and().logout().logoutUrl("/logoutUrl").logoutSuccessUrl("/");
    }
}
