package com.packtpub.celebrities.components;

import java.util.Locale;

import org.apache.tapestry.ComponentResources;
import org.apache.tapestry.annotations.OnEvent;
import org.apache.tapestry.annotations.Parameter;
import org.apache.tapestry.annotations.Persist;
import org.apache.tapestry.ioc.annotations.Inject;
import org.apache.tapestry.runtime.Component;
import org.apache.tapestry.services.PersistentLocale;

import com.packtpub.celebrities.pages.AddCelebrity;
import com.packtpub.celebrities.pages.Registration;
import com.packtpub.celebrities.pages.ShowAll;
import com.packtpub.celebrities.pages.Start;

public class Border {
	
	@Parameter(required = true, defaultPrefix = "literal")
	private String pageTitle; 
	    
	public String getPageTitle() {
	  return pageTitle;
	}

	/*@Inject
	private PersistentLocale persistentLocale;

	@Inject
	private Locale currentLocale;*/
	
	@Inject
	private ComponentResources resources;
	
	/*@Persist
	private String localeLabel;*/
	
	public boolean isNotStart() {
	  return !getPageName().equals(Start.class.getName()); 
	}
	    
	public boolean isRegistration() {
	  return getPageName().equals(Registration.class.getName()); 
	}
	    
	public boolean isShowAll() {
	  return getPageName().equals(ShowAll.class.getName()); 
	}
	    
	public boolean isAddCelebrity() {
	  return getPageName().equals(AddCelebrity.class.getName()); 
	}
	    
	private String getPageName() {
	  Component page = resources.getContainer();
	  return page.getClass().getName();
	}

	/*public String getLocaleLabel() {
		if (localeLabel == null) {
			if (currentLocale.equals(Locale.GERMAN)) {
				localeLabel = new Locale("en").getDisplayName(Locale.ENGLISH);
			} 
			else {
				localeLabel = new Locale("de").getDisplayName(Locale.GERMAN);
			}
		}
		return localeLabel;
	}

	@OnEvent(component = "switchlocale")
	void changeLocale() {
		localeLabel = currentLocale.getDisplayName(currentLocale);
		if (currentLocale.equals(Locale.GERMAN)) {
			persistentLocale.set(Locale.ENGLISH); 
		} 
		else {
			persistentLocale.set(Locale.GERMAN);
		}
	}*/
}