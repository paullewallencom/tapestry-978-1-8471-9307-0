package com.packtpub.celebrities.pages;

import org.apache.tapestry.annotations.ApplicationState;
import org.apache.tapestry.annotations.Persist;

import com.packtpub.celebrities.data.IDataSource;
import com.packtpub.celebrities.model.Celebrity;

public class AddCelebrity {
	@ApplicationState
	private IDataSource dataSource;

	@Persist
	private Celebrity celebrity;

	Object onSubmitFromCelebrity() {
		dataSource.addCelebrity(celebrity);
		return ShowAll.class;
	}

	public Celebrity getCelebrity() {
		return celebrity;
	}

	public void setCelebrity(Celebrity celebrity) {
		this.celebrity = celebrity;
	}
}
