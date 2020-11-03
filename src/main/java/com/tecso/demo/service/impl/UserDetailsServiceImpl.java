package com.tecso.demo.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tecso.demo.entity.User;
import com.tecso.demo.entity.UserRole;
import com.tecso.demo.repository.UserRepository;

@Service("userService")
//se implementa el servicio user detail service que utiliza spring security para autenticar usuarios
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;

	// metodo que se encargara de llamar a nuestro user repository y encontrar un
	// usuario por el username para obtener una entidad usuario que se convertia en
	// un objeto tipo user detail, para ello se crean dos metodos privados abajo de
	// este
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		List<GrantedAuthority> authorities = buildAuthorities(user.getUserRoles());
		return buildUser(user, authorities);
	}

	// granted authorities es el objeto que tiene spring securyty que en realidad es
	// la entidad role y es el que necesita para saber os roles del usuario
	// autenticado. Se encargara de construir el usuario
	private org.springframework.security.core.userdetails.User buildUser(User user, List<GrantedAuthority> authorities) {

		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.isEnabled(), true, true, true, authorities);
	}

	// convierte los roles en una lista de granted authorities y recibe como
	// parametro el set de user roles que declaramos en la entidad user
	private List<GrantedAuthority> buildAuthorities(Set<UserRole> userRoles) {
		Set<GrantedAuthority> auths = new HashSet<GrantedAuthority>();

		for (UserRole userRole : userRoles) {
			auths.add(new SimpleGrantedAuthority(userRole.getRole()));
		}

		return new ArrayList<GrantedAuthority>(auths);
	}

}
