package java02.test21.spring.exam04;

public class Car {
	String model;
	int cc;
	
	public Car(String model){
		this.model = model;
	}
	
	public Car(String model, int cc){
		this.model = model;
		this.cc = cc;
	}//파라미터 값이 2개인 생성자.
	
	public Car(){}
	
	@Override
	public String toString() {
		return "Car [model=" + model + ", cc=" + cc + "]";
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
	
}
