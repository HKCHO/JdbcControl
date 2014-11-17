package java02.test21.spring.exam13;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class MyCustomDateEditor extends PropertyEditorSupport {
  
  @Override
  public void setAsText(String text) throws IllegalArgumentException {
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    
    try {
      setValue(df.parse(text));
    } catch (ParseException e) {
      throw new IllegalArgumentException(e);
    }
  }

}







