package com.packtpub.celebrities.util;

import com.packtpub.celebrities.model.Celebrity;
import java.util.ArrayList;
import java.util.List;
import org.apache.tapestry.OptionGroupModel;
import org.apache.tapestry.OptionModel;
import org.apache.tapestry.util.AbstractSelectModel;

public class CelebritySelectModel extends AbstractSelectModel {
    
  private List<Celebrity> celebrities;
    
  public CelebritySelectModel(List<Celebrity> celebrities) {
    this.celebrities = celebrities;
  }

  public List<OptionGroupModel> getOptionGroups() {
    return null;
  }

  public List<OptionModel> getOptions() {
    List<OptionModel> list = new ArrayList<OptionModel>();
    for (Celebrity c : celebrities) {
      list.add(new CelebrityOptionModel(c));
    }
    return list;
  } 
}