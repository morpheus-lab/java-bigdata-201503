package system.apis;

class Point /* extends java.lang.Object */ {
	int x, y;
	public Point(int x, int y) {
		this.x = x; this.y = y;
	}
	
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
}

public class ObjectClass {
	
	public static void main(String[] args) {
		Point p = new Point(2, 3);
		System.out.println(p.getClass().getName());
		System.out.println(p.hashCode());
		System.out.println(p.toString());
		System.out.println(p);
	}
	
}
