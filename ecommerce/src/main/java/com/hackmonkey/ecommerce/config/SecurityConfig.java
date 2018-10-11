package com.hackmonkey.ecommerce.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	protected void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.inMemoryAuthentication()
			.withUser("admin").password(passwordEncoder().encode("admin")).roles("ADMIN");
	}
	
	private static final String[] PUBLIC_MATCHERS = {
			"/css/**",
			"/js/**",
			"/image/**",
			"/newUser",
			"/forgetPassword",
			"/login",
			"/fonts/**"
			
	};
	
	protected void configure(HttpSecurity http) throws Exception
	{
		/*::: DESABILITAR SEGURIDAD :::
		 *  EN ESTA PARTE SE CONSIDERA EL ORDEN DE LAS SENTENCIAS
		 * 
		http.authorizeRequests()
			.anyRequest()
			.permitAll()
			.and().csrf().disable();
		*/
		
		http
			.authorizeRequests().
		/*	antMatchers("/**").*/
			antMatchers(PUBLIC_MATCHERS).
			permitAll().anyRequest().authenticated();

		
		http
			.csrf().disable().cors().disable()
			.formLogin().failureUrl("/login?error")
			.defaultSuccessUrl("/")
			.loginPage("/login").permitAll()
			.and()
			.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.logoutSuccessUrl("/?logout").deleteCookies("remember-me").permitAll()
			.and()
			.rememberMe();
		
		/*
		http
			.authorizeRequests()
			.antMatchers("/login*").anonymous() // Estamos permitiendo el acceso anónimo en /login para que los usuarios puedan autenticarse. 
			.anyRequest().authenticated()
			.and()
			.formLogin()
			.loginPage("/login") 		// la página de inicio de sesión personalizada
			.defaultSuccessUrl("/") 	// la página de destino después de un inicio de sesión exitoso
			.failureUrl("/login?error") // la página de destino después de un inicio de sesión fallido
			.and()
			.logout().logoutSuccessUrl("/login");
	
		
		http.formLogin()
	      .loginPage("/login")
	      .loginProcessingUrl("/perform_login")
	      .defaultSuccessUrl("/index",true)
	      .failureUrl("/login?error=true");
	      */
	}
	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
}
