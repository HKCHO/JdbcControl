package java02.test21.spring.exam02;

public class Car {
	String model;
	int cc;
	
	public Car(String model){
		this.model = model;
	}
	
	public Car(){}
	
	
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
	
}
