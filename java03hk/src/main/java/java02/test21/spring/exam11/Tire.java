package java02.test21.spring.exam11;

public class Tire {
	String maker;
	int width;
	int height;
	int radial;
	
	
	
	@Override
	public String toString() {
		return "Tire [maker=" + maker + ", width=" + width + ", height=" + height
				+ ", radial=" + radial + "]";
	}
	public String getMaker() {
		return maker;
	}
	public void setMaker(String maker) {
		this.maker = maker;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getRadial() {
		return radial;
	}
	public void setRadial(int radial) {
		this.radial = radial;
	}
	
	
	
}
