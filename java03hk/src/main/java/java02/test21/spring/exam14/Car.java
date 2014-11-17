package java02.test21.spring.exam14;

import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component("c01") //객체의 이름 지정하기

//객체의 이름을 지정하지 않으면 기본적으로 클래스의 이름을 객체의 이름으로 사용한다.
//대문자는 소문자로 치환한다.
@Component
public class Car {
  String model;
  int cc;
  
  @Autowired
  Engine engine;
  Set<Tire> tires;
  Map<String,Object> options;
  
  public Car() {}
  
  public Car(String model) {
    this.model = model;
  }
  
  public Car(String model, int cc) {
    this.model = model;
    this.cc = cc;
  }
  @Override
  public String toString() {
    return "Car [model=" + model + ", cc=" + cc + ", engine=" + engine
        + ", tires=" + tires + ", options=" + options + "]";
  }
  public Map<String, Object> getOptions() {
    return options;
  }
  public void setOptions(Map<String, Object> options) {
    this.options = options;
  }
  public Set<Tire> getTires() {
    return tires;
  }
  
  public void setTires(Set<Tire> tires) {
    this.tires = tires;
  }
  
  public String getModel() {
    return model;
  }
  
  public void setModel(String model) {
    this.model = model;
  }
  
  public int getCc() {
    return cc;
  }
  
  public void setCc(int cc) {
    this.cc = cc;
  }
  
  public Engine getEngine() {
    return engine;
  }
  
  @Autowired
  public void setEngine(Engine engine) {
    this.engine = engine;
  }
  
  
}
