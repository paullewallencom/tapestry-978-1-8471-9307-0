package com.packtpub.celebrities.pages;

import org.apache.tapestry.Asset;
import org.apache.tapestry.annotations.ApplicationState;
import org.apache.tapestry.annotations.Component;
import org.apache.tapestry.annotations.Path;
import org.apache.tapestry.corelib.components.Form;
import org.apache.tapestry.ioc.Messages;
import org.apache.tapestry.ioc.annotations.Inject;

import com.packtpub.celebrities.model.User;
import com.packtpub.celebrities.util.Security;

/**
 * Start page of application celebrities.
 */
public class Start {
	@Inject
	@Path("context:assets/styles.css")
	private Asset styles;

	public Asset getStyles() {
		return styles;
	}

	@Component
	private Form loginForm;

	@Inject
	private Messages messages;

	private String userName;

	private String password;

	@ApplicationState
	private User user;

	Object onSuccess() {
		return ShowAll.class;
	}

	void onValidate() {
		User authenticatedUser = Security.authenticate(userName, password);
		if (authenticatedUser != null) {
			user = authenticatedUser;
		} else {
			loginForm.recordError(messages.get("authentication-failed"));
		}
	}

	/*Object onSubmitFromLoginForm() {
		Class nextPage = null;
		User authenticatedUser = null;
		authenticatedUser = Security.authenticate(userName, password);
		if (authenticatedUser != null) {
			user = authenticatedUser;
			nextPage = ShowAll.class;
		} else {
			nextPage = Registration.class;
		}
		return nextPage;
	}*/

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