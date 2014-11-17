package java02.test21.spring.exam13;

import java.beans.PropertyEditorSupport;


public class MyCustomEngineEditor extends PropertyEditorSupport {
  
  @Override
  public void setAsText(String text) throws IllegalArgumentException {
    String[] token = text.split(";");
    Engine engine = new Engine(token[0], Integer.parseInt(token[1]));
    setValue(engine);
  }

}







