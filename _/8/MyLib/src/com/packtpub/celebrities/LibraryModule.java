package com.packtpub.celebrities;

import com.packtpub.celebrities.services.SupportedLocales;
import com.packtpub.celebrities.services.SupportedLocalesImpl;
import org.apache.tapestry.ioc.Configuration;
import org.apache.tapestry.ioc.ServiceBinder;
import org.apache.tapestry.services.LibraryMapping;

public class LibraryModule {

    public static void bind(ServiceBinder binder) {       
        binder.bind(SupportedLocales.class, SupportedLocalesImpl.class);
    }
  
    public static void contributeComponentClassResolver(Configuration<LibraryMapping> configuration) {
        configuration.add(new LibraryMapping("mylib", "com.packtpub.celebrities"));
    }
}
