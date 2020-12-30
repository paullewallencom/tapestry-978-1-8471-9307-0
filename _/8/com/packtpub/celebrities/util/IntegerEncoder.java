package com.packtpub.celebrities.util;

import org.apache.tapestry.ValueEncoder;

public class IntegerEncoder implements ValueEncoder {

	public String toClient(Object i) {
		return i.toString();
	}

	public Object toValue(String s) {
		return new Integer(s);
	}
}