package inheritance.downcasting;

public class ShapeTest {
	
	static void process(Shape s) {
//		if (s instanceof Circle) {
//			Circle c = (Circle) s;
//			c.makeArea();
//			c.makeCircum();
//		} else if (s instanceof Rectangle) {
//			Rectangle r = (Rectangle) s;
//			r.makeArea();
//			r.makeCircum();
//		}
		
		s.makeArea();
		s.makeCircum();
		s.display();
	}
	
	public static void main(String[] args) {
		process(new Circle(3.0));
//		process(new Rectangle(4.0, 5.0));
	}
	
}
