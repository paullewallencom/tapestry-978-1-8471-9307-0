package com.packtpub.celebrities.util;

import com.packtpub.celebrities.model.Celebrity;
import java.util.Map;
import org.apache.tapestry.OptionModel;

public class CelebrityOptionModel implements OptionModel {
    
  private Celebrity celebrity;
    
  public CelebrityOptionModel(Celebrity celebrity) {
    this.celebrity = celebrity;
  }

  public String getLabel() {
    return celebrity.getFirstName() + " " + 
      celebrity.getLastName();
  }

  public boolean isDisabled() {
    return false;
  }

  public Map<String, String> getAttributes() {
    return null;
  }

  public Object getValue() {
    return celebrity;
  }
}