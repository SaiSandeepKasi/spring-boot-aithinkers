package com.springboot_Rest.Rest_crud_APIS.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;


import static org.springframework.security.provisioning.JdbcUserDetailsManager.*;

@Configuration
public class DemoSecurityconfig {


    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
//jdbc athenication was performed here
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "select user_id,pw,active from members where user_id=?");

        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select user_id, roles from members roles where user_id=?");


        return jdbcUserDetailsManager;
    }

    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer -> configurer
                .requestMatchers(HttpMethod.GET,"/api/employees").hasRole("Employee")
                .requestMatchers(HttpMethod.GET,"/api/employees/* *").hasRole("Employee")
                .requestMatchers(HttpMethod.PUT,"/api/employees").hasRole("Manager")
                .requestMatchers(HttpMethod.PUT,"/api/employees/**").hasRole("Manager")
                .requestMatchers(HttpMethod.PATCH,"/api/employees/**").hasRole("Manager")
                .requestMatchers(HttpMethod.DELETE,"/api/employees/**").hasRole("Admin")
        );

        http.httpBasic(Customizer.withDefaults());
        //diable cross site Request Forgery(CSRF)
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }
        /*
    @Bean
    public InMemoryUserDetailsManager userDetailsManagerger(){
        UserDetails john= User.builder()
                .username("john")
                .password("{noop}test123")
                .roles("Employee")
                .build();
        UserDetails mary= User.builder()
                .username("mary")
                .password("{noop}test123")
                .roles("Employee","Manager")
                .build();
        UserDetails jeevan= User.builder()
                .username("jeevan")
                .password("{noop}test123")
                .roles("Employee","Manager","Admin")
                .build();
                return new InMemoryUserDetailsManager(john, mary, jeevan);
    }

     */


}
