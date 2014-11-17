package java02.test21.spring.exam10;

public class EngineFactory2 {
	
	public Engine createEngine(String type) {
		if (type.equals("sedan")){
			return new Engine("현대자동차", 16);
		} else if (type.equals("sport")) {
			return new Engine("기아자동차", 18);
		} else if (type.equals("SUV")) {
			return new Engine("벤츠", 20);
		} else { //limousine
			return new Engine("GM", 22);
		}
	}
	
}
