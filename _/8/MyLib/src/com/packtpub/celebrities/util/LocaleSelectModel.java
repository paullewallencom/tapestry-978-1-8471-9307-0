package com.packtpub.celebrities.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.apache.tapestry.OptionGroupModel;
import org.apache.tapestry.OptionModel;
import org.apache.tapestry.util.AbstractSelectModel;

public class LocaleSelectModel extends AbstractSelectModel {
    
    private String locales;
    
    public LocaleSelectModel(String locales) {
        this.locales = locales;
    }

    public List<OptionGroupModel> getOptionGroups() {
        return null;
    }

    public List<OptionModel> getOptions() {
        if (locales != null) {
            List<OptionModel> locList = new ArrayList<OptionModel>();
            String[] locs = locales.split(",");
            for (String str : locs) {
                locList.add(new LocaleOptionModel(new Locale(str)));
            }
            return locList;
        }
        return null;
    }
    
}
