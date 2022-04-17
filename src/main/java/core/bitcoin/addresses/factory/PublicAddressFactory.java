package main.java.core.bitcoin.addresses.factory;

import java.security.KeyPairGenerator;
import java.security.spec.ECGenParameterSpec;

import main.java.core.bitcoin.addresses.PrivateAddress;

public abstract class PublicAddressFactory implements AddressFactory {
	
	// ECDSA -  Elliptic Curve Digital Signature Algorithm - secp256k1
	
	PrivateAddress privateAddress;
	
	public PublicAddressFactory(PrivateAddress privateKey) {
		this.privateAddress = privateKey;
	}
	
	public PublicAddressFactory(byte[] privateKey) {
		this.privateAddress = new PrivateAddress(privateKey);
	}

	
	public PublicAddressFactory(int sizeInBytes) {
		this.privateAddress = new PrivateAddressFactory(256).create();
	}

	
	public PublicAddressFactory() {
		this.privateAddress = new PrivateAddressFactory(256).create();
	}

	
	
	
	public PrivateAddress getPrivateAddress() {
		return this.privateAddress;
	}
	
	
	public ECGenParameterSpec getSecp256k1CurveParameters() {
		ECGenParameterSpec curveParameters = new ECGenParameterSpec("secp256k1");
		return curveParameters;
	}

	public KeyPairGenerator getECGenerator() {
		KeyPairGenerator ecGen = null;
		try {
			//KeyFactory ah = KeyFactory.getInstance("EC");
			
			ecGen = KeyPairGenerator.getInstance("EC");
		} catch (Exception e) {e.printStackTrace();}
		
		return ecGen;
	}
	
}
