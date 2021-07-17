package com.sukuawali.sukuawalibackend.configurations;

import com.sukuawali.sukuawalibackend.services.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    MyUserDetailsService myUserDetailsService;

    @Autowired
    DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().
                authorizeRequests().antMatchers("/sukuas/add").hasAnyAuthority("ADMIN")
                .antMatchers("/orders/delivered").hasAnyAuthority("DELIVERY_GUY")
                .antMatchers("/user/**").hasAuthority("ADMIN")
                .antMatchers("**").hasAnyAuthority("USER")
                .anyRequest().authenticated()
                .and().httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //auth.jdbcAuthentication().dataSource(dataSource);

        auth
                .userDetailsService(myUserDetailsService)
                .passwordEncoder(passwordEncoder());

//        auth.inMemoryAuthentication().withUser("jitu").password("{noop}jitu").roles("USER").and()
//                .withUser("deliveryboy").password("{noop}delivery@879").roles("DELIVERY_GUY").and()
//                .withUser("admin").password("{noop}jitu@879").authorities("WRITE_PRIVILEGES", "READ_PRIVILEGES").roles("ADMIN");

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }
}
