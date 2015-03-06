
public class Circle {
	
	// 인스턴스 변수
	double radius;	// 반지름
	double area;	// 면적
	
	// 생성자
	public Circle(double radius) {
		this.radius = radius;
	}
	
	// set필드이름() : setter, 필드에 값을 저장할 수 있는 메소드
	
	public Circle setRadius(double radius) {
		this.radius = radius;
		return this;
	}
	
	// getters - 필드 값을 조회하는 메소드
	public double getRadius() { return radius; }
	public double getArea() { return area; }
	
	public Circle calcArea() {	// 필드 radius를 이용해서 면적 계산하는 메소드
		area = Math.PI * radius * radius;
		return this;
	}
	
	public Circle display() {
		System.out.println("이 원의 반지름: " + radius + ", 면적: " + area);
		return this;
	}
	
	
	public static void main(String[] args) {
		
		Circle c1 = new Circle(3.0);
//		c1.calcArea();
//		c1.display();
//		
//		c1.setRadius(10.0);
//		c1.calcArea();
//		c1.display();
		
		c1.calcArea().display().setRadius(10.0).calcArea().display();
		
	}
	
}
