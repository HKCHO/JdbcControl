package java02.test21.spring.exam12;

import org.springframework.beans.factory.config.AbstractFactoryBean;

public class EngineFactoryBean extends AbstractFactoryBean<Engine> {
  String type;
  
  public void setType(String type) {
    this.type = type;
  }

  @Override
  public Class<?> getObjectType() {
    return Engine.class;
  }

  @Override
  protected Engine createInstance() throws Exception {
    if (type.equals("sedan")) {
      return new Engine("현대자동차", 16);
    } else if (type.equals("sports")) {
      return new Engine("기아자동차", 18);
    } else if (type.equals("SUV")) {
      return new Engine("벤츠", 20);
    } else { // Limousin
      return new Engine("GM", 22);
    }
  }
  

}
