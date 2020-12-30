package com.packtpub.celebrities.pages;
 
import java.util.Locale;

import org.apache.tapestry.Asset;
import org.apache.tapestry.annotations.ApplicationState;
import org.apache.tapestry.annotations.Component;
import org.apache.tapestry.annotations.OnEvent;
import org.apache.tapestry.annotations.Path;
import org.apache.tapestry.annotations.Persist;
import org.apache.tapestry.corelib.components.Form;
import org.apache.tapestry.ioc.Messages;
import org.apache.tapestry.ioc.annotations.Inject;
import org.apache.tapestry.services.PersistentLocale;

import com.packtpub.celebrities.model.User;
import com.packtpub.celebrities.util.Security;

/**
 * Start page of application celebrities.
 */
public class Start {
	@Inject
	@Path("context:assets/styles.css")
	private Asset styles;
	
	/*@Inject
	@Path("context:/assets/flag.gif")
	private Asset flag;
	    
	public Asset getFlag() {
	  return flag;
	}*/
	 
	@Inject 
	private PersistentLocale persistentLocale;
	
	@Inject
	private Locale currentLocale;
	
	@OnEvent(component="switchlocale")
	void changeLocale() {
	  localeLabel = currentLocale.getDisplayName(currentLocale);
	  if (currentLocale.equals(Locale.GERMAN)) {
	    persistentLocale.set(Locale.ENGLISH);
	  }
	  else {
	    persistentLocale.set(Locale.GERMAN);
	  }
	}

	public Asset getStyles() {
		return styles;
	}

	@Component
	private Form loginForm;

	@Inject
	private Messages messages;

	private String userName;

	private String password;

	@SuppressWarnings("unused")
	@ApplicationState
	private User user;
	
	@Persist
	private String localeLabel;
	    
	public String getLocaleLabel() {
	  if (localeLabel == null) {
	    if (currentLocale.equals(Locale.GERMAN)) {
	      localeLabel = 
	        new Locale("en").getDisplayName(Locale.ENGLISH);
	    }
	    else {
	      localeLabel = 
	        new Locale("de").getDisplayName(Locale.GERMAN);
	    }
	  }
	  return localeLabel; 
	}

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

	public String getOrRegisterLabel() {
		return messages.get("or-register");
	}

	/*
	 * Object onSubmitFromLoginForm() { Class nextPage = null; User
	 * authenticatedUser = null; authenticatedUser =
	 * Security.authenticate(userName, password); if (authenticatedUser != null) {
	 * user = authenticatedUser; nextPage = ShowAll.class; } else { nextPage =
	 * Registration.class; } return nextPage; }
	 */

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