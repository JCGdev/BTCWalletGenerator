package main.java.core.utils;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.Random;

public class SHA256 {
	
	public static byte[] calculateRandomDigest(int sizeInBytes) {
		MessageDigest digest = null;
		try {
			digest = MessageDigest.getInstance("SHA-256");
			
		} catch (NoSuchAlgorithmException e) { e.printStackTrace(); }
		
		byte[] randomBytesBuffer = new byte[sizeInBytes];
		Random random = new Random();
		random.nextBytes(randomBytesBuffer);
		
		byte[] hash = digest.digest(randomBytesBuffer);
		return hash;
	}
	
	

	public static byte[] calculateDigest(byte[] seed) {
		MessageDigest digest = null;
		try {
			digest = MessageDigest.getInstance("SHA-256");
			
		} catch (NoSuchAlgorithmException e) { e.printStackTrace(); }
		
		byte[] hash = digest.digest(seed);
		
		return hash;
	}
	
	
	
	public static byte[] calculateDigest(String seed, Charset charset) {
		MessageDigest digest = null;
		try {
			digest = MessageDigest.getInstance("SHA-256");
			
		} catch (NoSuchAlgorithmException e) { e.printStackTrace(); }
		
		byte[] seedConvertedToBytes = seed.getBytes(charset);
		byte[] hash = digest.digest(seedConvertedToBytes);
		
		return hash;
	}
	
	
	public static String calculateDigestInHexadecimal(byte[] seed) {
		return Hexadecimal.fromBytes(SHA256.calculateDigest(seed));
	}
	
	public static String calculateDigestInHexadecimal(String seed, Charset charset) {
		return Hexadecimal.fromBytes(SHA256.calculateDigest(seed, charset));
	}
	
	
	public static String calculateDigestInBase64(byte[] seed) {
		byte[] digest = SHA256.calculateDigest(seed);
		
		Encoder base64Encoder =  Base64.getEncoder();
		byte[] encodedDigest = base64Encoder.encode(digest);
		
		return new String(encodedDigest);	

	}
	
	public static String calculateDigestInBase64(String seed, Charset charset) {
		byte[] digest = SHA256.calculateDigest(seed, charset);
		
		Encoder base64Encoder =  Base64.getEncoder();
		byte[] encodedDigest = base64Encoder.encode(digest);
		
		return new String(encodedDigest);	

	}
	
	public static String calculateDigestInUTF8(byte[] seed) {
		byte[] digest = SHA256.calculateDigest(seed);
		return new String(digest);	

	}
	
	public static String calculateDigestInUTF8(String seed, Charset charset) {
		byte[] digest = SHA256.calculateDigest(seed, charset);
		return new String(digest);	

	}
	
	
}
