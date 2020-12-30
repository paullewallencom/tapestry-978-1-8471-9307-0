package com.packtpub.celebrities.pages;
 
import org.apache.tapestry.annotations.ApplicationState;
import org.apache.tapestry.annotations.Component;
import org.apache.tapestry.annotations.OnEvent;
import org.apache.tapestry.corelib.components.Form;
import org.apache.tapestry.ioc.Messages;
import org.apache.tapestry.ioc.annotations.Inject;

import com.packtpub.celebrities.model.User;
import com.packtpub.celebrities.util.Security;

/**
 * Start page of application celebrities.
 */
public class Start {
 
	@Component
	private Form loginForm;

	@Inject
	private Messages messages;

	private String userName;

	private String password;

	@SuppressWarnings("unused")
	@ApplicationState
	private User user;

	@OnEvent(value = "success", component = "loginForm")
	Object showCollection() {
		return ShowAll.class;
	} 

	@OnEvent(value = "validate", component = "loginForm")
	void validateInput() {
		User authenticatedUser = Security.authenticate(userName, password);
		if (authenticatedUser != null) {
			user = authenticatedUser;
		} else {
			loginForm.recordError(messages.get("authentication-failed"));
		}
	}

	public String getOrRegisterLabel() {
		return messages.get("or-register");
	}
 
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}