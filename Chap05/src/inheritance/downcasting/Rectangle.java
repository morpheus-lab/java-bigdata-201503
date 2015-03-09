package inheritance.downcasting;

public class Rectangle extends Shape {
	
	private double width;
	private double height;
	
	public Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}
	
	public void makeArea() {
		area = width * height;
	}
	
	public void makeCircum() {
		circum = (width + height) * 2;
	}

	public double getWidth() {
		return width;
	}

	public double getHeight() {
		return height;
	}
	
}
