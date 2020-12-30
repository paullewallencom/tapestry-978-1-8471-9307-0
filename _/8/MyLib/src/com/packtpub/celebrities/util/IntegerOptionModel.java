package com.packtpub.celebrities.util;
    
import java.util.Map;
import org.apache.tapestry.OptionModel;

public class IntegerOptionModel implements OptionModel {
	
    private Number number;

    public IntegerOptionModel(Number num) {
            number = num;
    }

    public Map<String, String> getAttributes() {
            return null;
    }

    public String getLabel() {
            return "" + number;
    }

    public Object getValue() {
            return number;
    }

    public boolean isDisabled() {
            return false;
    }
}
