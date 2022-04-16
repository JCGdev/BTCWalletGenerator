package main.java.core.bitcoin.addresses.formats;

import java.util.regex.Pattern;

import main.java.core.bitcoin.addresses.PublicAddress;
import main.java.core.bitcoin.addresses.PublicAddress.AddressType;

public class P2PK extends PublicAddress {
	
	public P2PK(byte[] address) {
		super(address);
	}

	@Override
	public AddressType getAddressType() {
		return PublicAddress.AddressType.P2PK;
	}

	@Override
	public Pattern getRegexPattern() {
		return null;
	}

	@Override
	public boolean isValid() {
		return false;
	}

}
