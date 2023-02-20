package com.example.Wishlist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/uwish", "/uwish/login", "/uwish/signup", "/h2", "/h2/**", "/style.css").permitAll()
                    /*.antMatchers("/admin").hasRole("ADMIN")*/
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .loginPage("/uwish/login")
                    .defaultSuccessUrl("/uwish/wishlist", true)
                    .permitAll();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withDefaultPasswordEncoder().username("Lisa").password("123").roles("USER").build());
        manager.createUser(User.withDefaultPasswordEncoder().username("Rune").password("123").roles("USER").build());
        return manager;
    }
}
