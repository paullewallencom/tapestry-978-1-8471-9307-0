package com.packtpub.celebrities.util;

import com.packtpub.celebrities.data.IDataSource;
import com.packtpub.celebrities.model.Celebrity;
import org.apache.tapestry.ValueEncoder;

public class CelebrityEncoder implements ValueEncoder {
    
  private IDataSource source;
    
  public CelebrityEncoder(IDataSource source) {
    this.source = source;
  }
    
  public String toClient(Object obj) {
    return "" + ((Celebrity)obj).getId();
  }

  public Object toValue(String str) {
    return source.getCelebrityById(Integer.parseInt(str));
  }   
}