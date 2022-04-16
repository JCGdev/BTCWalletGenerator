package main.java.core.bitcoin.addresses;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import main.java.core.utils.Hexadecimal;

public abstract class PublicAddress extends BitcoinAddress{

	public PublicAddress(byte[] address) {
		super(address);
	}

	// P2PHK --> LEGACY FORMAT
	// P2SH --> Pay-to-Script-Hash
	// BENCH32 --> Native SegWit
	public static enum AddressType {
		P2PK, P2PKH, P2SH, BENCH32
		
	}
	
	public abstract AddressType getAddressType();
	public abstract Pattern getRegexPattern();

	public boolean isValid() {
		Pattern pattern = this.getRegexPattern();
		Matcher matcher = pattern.matcher(this.getAddressInHexadecimal());
		
		return matcher.matches();
	}
	

	
}
