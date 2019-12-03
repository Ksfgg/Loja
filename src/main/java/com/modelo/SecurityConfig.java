package com.modelo;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("magal")
		.password("magal")
		.roles("USER")
		.and()	
		.withUser("mic")
		.password("12345")
		.roles("ADMIN")
		.and()
		.withUser("user")
		.password("admin")				
		.roles("ADMIN");
			
	}
	
	@Bean
	public PasswordEncoder PasswordEncoder() {
	return NoOpPasswordEncoder.getInstance();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()		
		.antMatchers("/resources/**", "/webjars/**").permitAll()
		.antMatchers("/").hasAnyRole("ADMIN","USER")		
		.antMatchers("/admin").hasRole("ADMIN")
		.antMatchers("/editar/id").hasRole("ADMIN")
		.antMatchers("/cadastro").hasAnyRole("ADMIN","USER")
		.antMatchers("/delete/id").hasRole("ADMIN")
		.anyRequest().authenticated()
		.and()
		.formLogin();
	}
	
}