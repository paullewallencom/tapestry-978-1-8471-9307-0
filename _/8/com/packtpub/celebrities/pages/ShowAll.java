package com.packtpub.celebrities.pages;

import java.text.Format;
import java.util.Date;
import java.util.List;

import org.apache.tapestry.SelectModel;
import org.apache.tapestry.ValueEncoder;
import org.apache.tapestry.annotations.ApplicationState;
import org.apache.tapestry.annotations.InjectPage;
import org.apache.tapestry.annotations.Persist;
import org.apache.tapestry.grid.GridDataSource;

import com.packtpub.celebrities.data.IDataSource;
import com.packtpub.celebrities.model.Celebrity;
import com.packtpub.celebrities.model.User;
import com.packtpub.celebrities.util.CelebrityEncoder;
import com.packtpub.celebrities.util.CelebritySelectModel;
import com.packtpub.celebrities.util.CelebritySource;
import com.packtpub.celebrities.util.Formats;

public class ShowAll {
	@SuppressWarnings("unused")
	@ApplicationState
	private User user;

	private boolean userExists;

	@ApplicationState
	private IDataSource dataSource;

	@SuppressWarnings("unused")
	@InjectPage
	private Details detailsPage;

	private Celebrity celebrity;

	String onActivate() {
		if (!userExists)
			return "Start";
		return null;
	}

	/*
	 * @OnEvent(component="detailsLink") Object onShowDetails(long id) {
	 * Celebrity celebrity = dataSource.getCelebrityById(id);
	 * detailsPage.setCelebrity(celebrity); return detailsPage; }
	 */

	public GridDataSource getCelebritySource() {
		return new CelebritySource(dataSource);
	}

	public List<Celebrity> getAllCelebrities() {
		System.out.println("Getting all celebrities...");
		return dataSource.getAllCelebrities();
	}

	public Celebrity getCelebrity() {
		return celebrity;
	}

	public void setCelebrity(Celebrity celebrity) {
		this.celebrity = celebrity;
	}

	public Format getDateFormat() {
		return Formats.getDateFormat();
	}

	public SelectModel getCelebrityModel() {
		return new CelebritySelectModel(getAllCelebrities());
	}

	public ValueEncoder getCelebrityEncoder() {
		return new CelebrityEncoder(dataSource);
	}

	@Persist
	private Celebrity selectedCelebrity;

	public Celebrity getSelectedCelebrity() {
		return selectedCelebrity;
	}

	public void setSelectedCelebrity(Celebrity selectedCelebrity) {
		this.selectedCelebrity = selectedCelebrity;
	}

	public String getSelectedCelebrityName() {
		if (selectedCelebrity == null)
			return "";
		return selectedCelebrity.getFirstName() + " "
				+ selectedCelebrity.getLastName();
	}

	private Date theDate;

	public Date getTheDate() {
		return theDate;
	}

	public void setTheDate(Date theDate) {
		this.theDate = theDate;
	}

	public Date getLowerLimit() {
		return new Date();
	}
}
