package main.java.core.bitcoin.addresses.formats;

import java.util.regex.Pattern;

import main.java.core.bitcoin.addresses.PublicAddress;
import main.java.core.bitcoin.addresses.PublicAddress.AddressType;

public class P2PKH extends PublicAddress {

	public P2PKH(byte[] address) {
		super(address);

	}

	@Override
	public AddressType getAddressType() {
		return PublicAddress.AddressType.P2PKH;
	}

	@Override
	public Pattern getRegexPattern() {
		return Pattern.compile("1.{33}", Pattern.CASE_INSENSITIVE);
	}


	


}
