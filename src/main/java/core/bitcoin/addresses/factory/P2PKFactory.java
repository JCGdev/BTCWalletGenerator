package main.java.core.bitcoin.addresses.factory;


import main.java.core.bitcoin.addresses.PrivateAddress;
import main.java.core.bitcoin.addresses.formats.P2PKAddress;

public class P2PKFactory extends PublicAddressFactory {

	public P2PKFactory(PrivateAddress privKey) {
		super(privKey);
	}
	
	public P2PKFactory(byte[] privKey) {
		super(privKey);
	}
	
	public P2PKFactory(int byteSize) {
		super(byteSize);
	}
	
	public P2PKFactory() {
		super();
	}
	
	
	@Override
	public P2PKAddress create() {
		//TODO Implement secp256k1 Eliptic Curve as this is not working as expected
		
//		ECGenParameterSpec ecParameters = this.getSecp256k1CurveParameters();
///		KeyPairGenerator generator = this.getECGenerator();
		
//		try {
//			generator.initialize(ecParameters, new SecureRandom(this.getPrivateAddress().getAddress()));
//		} catch (InvalidAlgorithmParameterException e) {e.printStackTrace();}
//		
//		KeyPair key = generator.generateKeyPair();
//		
//		return new P2PKAddress(key.getPublic().getEncoded());
		
		return null;
	}
	

}
