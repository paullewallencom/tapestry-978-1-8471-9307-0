package com.packtpub.celebrities.components;

import java.util.Calendar;
import java.util.Date;

import org.apache.tapestry.ComponentResources;
import org.apache.tapestry.Field;
import org.apache.tapestry.SelectModel;
import org.apache.tapestry.ValidationTracker;
import org.apache.tapestry.ValueEncoder;
import org.apache.tapestry.annotations.Environmental;
import org.apache.tapestry.annotations.Parameter;
import org.apache.tapestry.annotations.SetupRender;
import org.apache.tapestry.ioc.Messages;
import org.apache.tapestry.ioc.annotations.Inject;
import org.apache.tapestry.services.ComponentDefaultProvider;
import org.apache.tapestry.util.EnumSelectModel;

import com.packtpub.celebrities.util.IntegerEncoder;
import com.packtpub.celebrities.util.IntegerSelectModel;
import com.packtpub.celebrities.util.Month;

public class DateInput implements Field {

	@Environmental
	private ValidationTracker tracker;

	@Parameter(required = true)
	private Date date;

	@Parameter
	private Date dateFrom;

	@Inject
	private Messages messages;

	private Calendar c = Calendar.getInstance();

	@SetupRender
	void setupCalendar() {
		c.setTime(date == null ? new Date() : date);
	}

	public String getElementName() {
		return null;
	}

	@Parameter(defaultPrefix = "literal")
	private String label;

	@Inject
	private ComponentResources resources;

	@Inject
	private ComponentDefaultProvider defaultProvider;

	String defaultLabel() {
		return defaultProvider.defaultLabel(resources);
	}

	public String getLabel() {
		return label;
	}

	public String getClientId() {
		return resources.getId();
	}

	@Parameter
	private boolean disabled;

	public boolean isDisabled() {
		return disabled;
	}

	public SelectModel getDayModel() {
		return new IntegerSelectModel(1, 31);
	}

	public SelectModel getYearModel() {
		return new IntegerSelectModel(1900, 2010);
	}

	public SelectModel getMonthModel() {
		return new EnumSelectModel(Month.class, messages);
	}

	public ValueEncoder getEncoder() {
		return new IntegerEncoder();
	}

	public int getDay() {
		return c.get(Calendar.DATE);
	}

	public void setDay(int day) {
		c.set(Calendar.DATE, day);
	}

	public Month getMonth() {
		return Month.values()[c.get(Calendar.MONTH)];
	}

	public void setMonth(Month month) {
		c.set(Calendar.MONTH, month.getOrder());
	}

	public int getYear() {
		return c.get(Calendar.YEAR);
	}

	public void setYear(int year) {
		c.set(Calendar.YEAR, year);
		date = c.getTime();
		if (dateFrom != null && date.before(dateFrom)) {
			tracker.recordError(this, messages.get("too-early"));
		}
	}
}