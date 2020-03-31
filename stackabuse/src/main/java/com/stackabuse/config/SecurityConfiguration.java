package com.stackabuse.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
    public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
//	@Override
//	public void configure(AuthenticationManagerBuilder auth) throws Exception {
//		  auth.inMemoryAuthentication()
//		  .withUser("user").password("{noop}password").roles("USER") .and()
//		  .withUser("admin").password("{noop}password").roles("ADMIN");
//	}

//        @Override
//        protected void configure(HttpSecurity http) throws Exception {
//            http.authorizeRequests()
//                .antMatchers("/register").permitAll()
//                .antMatchers("/confirm").permitAll();
//        }
        
        @Override
    	public void configure(HttpSecurity http) throws Exception {
    		http 
    			.csrf() 
    			.disable()
    			.authorizeRequests()
    			.antMatchers("/**").permitAll()
    			.anyRequest().authenticated();
    	}
        
}