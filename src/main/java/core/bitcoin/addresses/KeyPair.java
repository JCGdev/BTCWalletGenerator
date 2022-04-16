package main.java.core.bitcoin.addresses;

public class KeyPair {
	
	private PrivateAddress privateAddress;
	private PublicAddress publicAddress;
	
	public KeyPair(PrivateAddress privAddr, PublicAddress pubAddr) {
		this.privateAddress = privAddr;
		this.publicAddress = pubAddr;
	}

	
	public PrivateAddress getPrivateAddress() {
		return this.privateAddress;
	}
	
	
	public PublicAddress getPublicAddress() {
		return this.publicAddress;
	}
	
	
	
}
