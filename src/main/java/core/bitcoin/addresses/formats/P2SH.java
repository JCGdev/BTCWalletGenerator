package main.java.core.bitcoin.addresses.formats;

import java.util.regex.Pattern;

import main.java.core.bitcoin.addresses.PublicAddress;
import main.java.core.bitcoin.addresses.PublicAddress.AddressType;

public class P2SH extends PublicAddress {

	public P2SH(byte[] address) {
		super(address);
	}

	@Override
	public AddressType getAddressType() {
		return PublicAddress.AddressType.P2SH;
	}

	@Override
	public Pattern getRegexPattern() {
		return Pattern.compile("3.{33}", Pattern.CASE_INSENSITIVE);
	}


}
