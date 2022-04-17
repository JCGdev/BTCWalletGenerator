package main.java.core.bitcoin.addresses;

public class PrivateAddress extends BitcoinAddress{

	public PrivateAddress(byte[] address) {
		super(address);
	}

	@Override
	public String getAlgorithm() {
		// TODO Auto-generated method stub
		return "sha256";
	}

	@Override
	public String getFormat() {
		return null;
	}

	@Override
	public byte[] getEncoded() {
		return this.getAddress();
	}
	
	// 256 bit --> 32 bytes
	


}
