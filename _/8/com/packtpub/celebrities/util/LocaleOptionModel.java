package com.packtpub.celebrities.util;

import java.util.Locale;
import java.util.Map;
import org.apache.tapestry.OptionModel;

public class LocaleOptionModel implements OptionModel {

	private Locale locale;

	public LocaleOptionModel(Locale locale) {
		this.locale = locale;
	}

	public String getLabel() {
		return locale.getDisplayName(locale);
	}

	public boolean isDisabled() {
		return false;
	}

	public Map<String, String> getAttributes() {
		return null;
	}

	public Object getValue() {
		return locale;
	}
}