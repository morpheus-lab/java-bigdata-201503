package inheritance.downcasting;

public class Circle extends Shape {
	
	private double radius;
	
	public Circle(double radius) {
		this.radius = radius;
	}
	
	public void makeArea() {
		area = Math.PI * Math.pow(radius, 2);
	}
	
	public void makeCircum() {
		circum = 2 * Math.PI * radius;
	}
	
	public double getRadius() {
		return radius;
	}
	
}
