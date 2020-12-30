package com.packtpub.celebrities.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.tapestry.OptionGroupModel;
import org.apache.tapestry.OptionModel;
import org.apache.tapestry.util.AbstractSelectModel;

public class IntegerSelectModel extends AbstractSelectModel {

	private List<OptionModel> options = new ArrayList<OptionModel>();

	public IntegerSelectModel(int numFrom, int numTo) {
		int increment = numTo > numFrom ? 1 : -1;
		for (int i = numFrom; i <= numTo; i += increment) {
			options.add(new IntegerOptionModel(i));
		}
	}

	public List<OptionGroupModel> getOptionGroups() {
		return null;
	}

	public List<OptionModel> getOptions() {
		return options;
	}
}