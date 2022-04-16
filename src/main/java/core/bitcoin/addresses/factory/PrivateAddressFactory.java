package main.java.core.bitcoin.addresses.factory;

import java.security.SecureRandom;
import java.util.Random;

import main.java.core.bitcoin.addresses.PrivateAddress;
import main.java.core.utils.SHA256;

public class PrivateAddressFactory implements AddressFactory  {
	
	byte[] seed;
	
	public PrivateAddressFactory(byte[] seed) {
		this.seed = seed;
	}
	
	public PrivateAddressFactory(int sizeInBytes) {
		SecureRandom randomGenerator = new SecureRandom();
		this.seed = randomGenerator.generateSeed(sizeInBytes);
		randomGenerator.nextBytes(this.seed);
	}
	
	public PrivateAddressFactory() {
		SecureRandom randomGenerator = new SecureRandom();
		this.seed = randomGenerator.generateSeed(256);
		randomGenerator.nextBytes(this.seed);
	}

	
	
	@Override
	public PrivateAddress create() {
		byte[] hashedSeed = SHA256.calculateDigest(seed);
		PrivateAddress address = new PrivateAddress(hashedSeed);
		return address;
	}
	
	
	

}
