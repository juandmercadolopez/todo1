package com.tecso.demo.crypt;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Encryption {
	
	public static String encrypt(String password) {
		BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
		return pe.encode(password);
	}
	
	public static void main(String[] args) {
		System.out.println(encrypt("password"));
	}

}
