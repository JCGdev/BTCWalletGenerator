package main.java.core;

import java.nio.charset.StandardCharsets;

import main.java.core.bitcoin.addresses.PrivateAddress;
import main.java.core.bitcoin.addresses.factory.PrivateAddressFactory;

public class Main {

	public static void main(String[] args) {
		
		byte[] seed = "ola".getBytes(StandardCharsets.UTF_8);
		PrivateAddress addr = new PrivateAddressFactory(seed).create();
		
		System.out.println(addr.getAddressInHexadecimal());
		
	}
	
}
