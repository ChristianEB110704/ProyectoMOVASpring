package com.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.example.DTO.UsuarioDTO;
import com.example.service.ServicioIMPL;

@Configuration
public class SpringSecurityConfig {
	@Autowired
	public ServicioIMPL service;
	
	@Bean
	static BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	UserDetailsService userDetailsService()throws Exception{
		InMemoryUserDetailsManager manager=new InMemoryUserDetailsManager();
		List<UsuarioDTO> usuarios=service.mostrarUsuarios();
		for(UsuarioDTO usuario:usuarios) {
			manager.createUser(User.withUsername(usuario.getNombre()).password(passwordEncoder().encode("prueba"))
					.roles("USER")
					.build());
		}
		
		manager.createUser(User
				.withUsername("admin")
				.password(passwordEncoder().encode("admin"))
				.roles("ADMIN","USER")
				.build());

		return manager;
	}
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http.authorizeHttpRequests(
				(authz)-> authz
				.requestMatchers("/","/css/**","/js/**","/image/**").permitAll()
				.requestMatchers("/**").hasAnyRole("USER")
				.requestMatchers("/habilidad/**").hasAnyRole("USER")
				.requestMatchers("/personajes/**").hasAnyRole("USER")
				.requestMatchers("/usuarios/mayorKDA").hasAnyRole("USER")
				.anyRequest().authenticated()
				)
		.formLogin(login->login.loginPage("/login") .defaultSuccessUrl("/", true).permitAll())
		.logout(logout -> logout.logoutSuccessUrl("/").permitAll());
		return http.build();
		
	}

}
