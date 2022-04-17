package main.java.core.bitcoin.addresses.formats;

import java.util.regex.Pattern;

import main.java.core.bitcoin.addresses.PublicAddress;
import main.java.core.bitcoin.addresses.PublicAddress.AddressType;

public class P2PKHAddress extends PublicAddress {

	public P2PKHAddress(byte[] address) {
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

	@Override
	public String getAlgorithm() {
		// TODO Auto-generated method stub
		return "scep256k1";
	}

	@Override
	public String getFormat() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public byte[] getEncoded() {
		// TODO Auto-generated method stub
		return this.getAddress();
	}


	


}
