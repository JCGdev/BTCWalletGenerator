package main.java.core.bitcoin.addresses;

import main.java.core.utils.Hexadecimal;

public abstract class BitcoinAddress {

	private byte[] address = new byte[32];
	
	public BitcoinAddress(byte[] addr) {
		assert addr.length == 32 : "Address must be 32 bytes long";
		this.address = addr;
	}
	
	
	public byte[] getAddress() {
		return this.address;
	}
	
	public String getAddressInHexadecimal() {
		return Hexadecimal.fromBytes(this.address);
	}
	
}
