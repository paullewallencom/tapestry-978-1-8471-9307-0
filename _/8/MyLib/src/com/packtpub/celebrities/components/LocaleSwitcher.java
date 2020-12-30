package com.packtpub.celebrities.components;

import java.util.Locale;

import org.apache.tapestry.SelectModel;
import org.apache.tapestry.ValueEncoder;
import org.apache.tapestry.ioc.annotations.Inject;
import org.apache.tapestry.services.PersistentLocale;

import com.packtpub.celebrities.services.SupportedLocales;
import com.packtpub.celebrities.util.LocaleEncoder;
import com.packtpub.celebrities.util.LocaleSelectModel;

public class LocaleSwitcher {
    
    @Inject 
    private PersistentLocale persistentLocale;
    
    @Inject
    private SupportedLocales supportedLocales;

    public Locale getSelectedLocale() {
        return persistentLocale.get();
    }

    public void setSelectedLocale(Locale selectedLocale) {
        persistentLocale.set(selectedLocale);
    }
    
    public SelectModel getLocaleModel() {
        return new LocaleSelectModel(supportedLocales.getSupportedLocales());
    }
    
    public ValueEncoder getLocaleEncoder() {
        return new LocaleEncoder();
    }
}
