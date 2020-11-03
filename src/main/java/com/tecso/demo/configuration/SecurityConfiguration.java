package com.tecso.demo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) /*
													 * @EnableGlobalMethodSecurity: anotacion que permite escribir
													 * anotaciones para controlar el acceso a los metodos segun la
													 * seguiridad, por ejemplo @PreAuthorized La clase
													 * WebSecurityConfigurerAdapter nos ayudara a guiarnos por la
													 * configuracion
													 */
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	// service que se añade al AuthenticationManagerBuilder
	@Autowired
	@Qualifier("userService")
	private UserDetailsService userService;

	/*
	 * componente de spring security, nos ayudara a añadir el user detail service
	 * que se creo con anterioridad
	 */
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
	}

	/*
	 * Este es el metodo que se debe sobreescribir para la configuracion permite las
	 * imagenes y los recursos css de la aplicacion y el resto es por autenticacion.
	 * Indica la pagina del login y la pagina de redireccion cuando el login fue
	 * satisfactorio, al igual que con el logout
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/build/**", "/docs/**", "/production/**", "/src/**", "/vendors/**", "/integration/**", "/images/**")
				.permitAll()
				.antMatchers("/customer_signup", "/admin_signup", "/password_recovery", "/password_confirm",
						"/registro/cliente", "/registro/administrador", "/registro/paso1/restorePassword",
						"/registro/paso2/restorePassword")
				.permitAll().anyRequest().authenticated().and().formLogin().loginPage("/login")
				.loginProcessingUrl("/logincheck").usernameParameter("username").passwordParameter("password")
				.defaultSuccessUrl("/loginsuccess").permitAll().and().logout().logoutUrl("/logout")
				.logoutSuccessUrl("/login?logout").permitAll();
	}

}
