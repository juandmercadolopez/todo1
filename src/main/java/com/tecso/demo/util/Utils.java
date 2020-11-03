package com.tecso.demo.util;

import java.util.Random;

public class Utils {
	
	public static String generateRandomNumer() {
		Random aleatorio = new Random();		
		return aleatorio.nextInt((999999999) - 0) + "";
	}

}
