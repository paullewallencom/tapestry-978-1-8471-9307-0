package com.packtpub.celebrities.pages;

import org.apache.tapestry.SelectModel;
import org.apache.tapestry.annotations.ApplicationState;
import org.apache.tapestry.annotations.OnEvent;
import org.apache.tapestry.annotations.Persist;
import org.apache.tapestry.ioc.Messages;
import org.apache.tapestry.ioc.annotations.Inject;
import org.apache.tapestry.util.EnumSelectModel;

import com.packtpub.celebrities.model.Country;
import com.packtpub.celebrities.model.Gender;
import com.packtpub.celebrities.model.User;

public class Registration {

	@SuppressWarnings("unused")
	@ApplicationState
	private User user;
	
	@Inject
	private Messages messages;

	@Persist
	private String userName;

	@Persist
	private String password;

	private String password2;

	@Persist
	private Gender gender = Gender.FEMALE;

	@Persist
	private boolean subscribe;

	@Persist
	private String email;
	
	@Persist
	private Country country;

	private boolean unsubscribe;

	private Class nextPage;

	Object onSubmitFromRegistrationForm() {
		System.out.println("The form was submitted!");
		if (unsubscribe)
			subscribe = false;
		return nextPage;
	}

	@OnEvent(component="submitButton")
	void onSubmitButton() {
		System.out.println("Submit button was pressed!");
		User newUser = new User("John", "Johnson");
		this.user = newUser;
		nextPage = ShowAll.class;
	}

	@OnEvent(component="resetButton")
	void onResetButton() { 
		System.out.println("Resetting...");
		userName = null;
		password = null;
		email = null;
		gender = null;
		subscribe = false;
	}
	
	public SelectModel getCountries() {
		return new EnumSelectModel(Country.class, messages);
	}
	
	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public boolean isPasswordNotSubmitted() {
		return userName == null;
	}

	public boolean isUnsubscribe() {
		return unsubscribe;
	}

	public void setUnsubscribe(boolean unsubscribe) {
		this.unsubscribe = unsubscribe;
	}

	public boolean isSubscribe() {
		return subscribe;
	}

	public void setSubscribe(boolean subscribe) {
		System.out.println("Setting subscribe: " + subscribe);
		this.subscribe = subscribe;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Gender getMale() {
		return Gender.MALE;
	}

	public Gender getFemale() {
		return Gender.FEMALE;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		System.out.println("Setting user name: " + userName);
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		System.out.println("Setting password: " + password);
		this.password = password;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}
}
