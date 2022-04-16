package main.java.core.utils;

import java.nio.charset.Charset;

public class Hexadecimal {

	
	public static String fromBytes(byte[] data) {
		StringBuilder hexadecimal = new StringBuilder();
	    for (byte b: data) {
	    	hexadecimal.append(String.format("%02x", b));
	    }
		
		return hexadecimal.toString();
	}
	
	
	public static String fromString(String data, Charset charset) {
		byte[] dataInBytes = data.getBytes(charset);
		return fromBytes(dataInBytes);
	}
	
}
