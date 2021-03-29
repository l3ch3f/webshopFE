package com.webshoptg.assignment.config;

import com.webshoptg.assignment.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.Collections;

//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
//    @Autowired
//    private DataSource dataSource;
//    @Autowired
//    private ProductService productService;
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable().and()
//
//
//                .authorizeRequests()
//                .antMatchers("/list_users").authenticated()
//                .antMatchers("/register").authenticated()
//                .anyRequest().permitAll()
//                .and().exceptionHandling()
//                .and().sessionManagement()
//                .and()
//                .formLogin()
//                .usernameParameter("email")
//                .defaultSuccessUrl("/list_users")
//                .permitAll()
//                .and()
//                .logout().logoutSuccessUrl("/").permitAll();
//
//    }



