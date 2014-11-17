package java02.test21.spring.exam10;

public class Engine {
	String maker;
	int valve;
	
	public Engine(){}
	
	public Engine(String maker, int valve){
		this.maker = maker;
		this.valve = valve;
	}

	@Override
	public String toString() {
		return "Engine [maker=" + maker + ", valve=" + valve + "]";
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public int getValve() {
		return valve;
	}

	public void setValve(int valve) {
		this.valve = valve;
	}
	
}
