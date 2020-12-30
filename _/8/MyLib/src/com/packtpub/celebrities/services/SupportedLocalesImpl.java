package com.packtpub.celebrities.services;

import org.apache.tapestry.ioc.annotations.Inject;
import org.apache.tapestry.ioc.annotations.Symbol;

public class SupportedLocalesImpl implements SupportedLocales {
    
    private String supportedLocales;
    
    public SupportedLocalesImpl(
            @Inject 
            @Symbol("tapestry.supported-locales")
            String locales) {
        supportedLocales = locales;
    }

    public String getSupportedLocales() {
        return supportedLocales;
    }  
}
