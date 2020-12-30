package com.packtpub.celebrities.pages;

import java.text.Format;

import org.apache.tapestry.annotations.ApplicationState;

import com.packtpub.celebrities.data.IDataSource;
import com.packtpub.celebrities.model.Celebrity;
import com.packtpub.celebrities.util.Formats;

public class Details {
	
	@ApplicationState
	private IDataSource dataSource;
	
	private Celebrity celebrity;
	
	void onActivate(long id) {
	    celebrity = dataSource.getCelebrityById(id);
	}

	public void setCelebrity(Celebrity c) {
		this.celebrity = c;
	}

	public Celebrity getCelebrity() {
		return celebrity;
	}

	public Format getDateFormat() {
		return Formats.getDateFormat();
	}
}
