package inheritance.downcasting;

public abstract class Shape {	// "도형"이라는 개념을 나타낸 클래스
	
	protected double area;		// 면적
	protected double circum;	// 둘레
	
	public void display() {
		System.out.println("면적: " + area + ", 둘레: " + circum);
	}
	
	protected abstract void makeArea();
	/*
	{
		System.out.println("Shape의 makeArea()");
		// 도형의 종류가 결정되기 전에는 면적을 계산할 수 없음
	}*/
	
	protected abstract void makeCircum();
	/*
	{
		System.out.println("Shape의 makeCircum()");
		// 도형의 종류가 결정되기 전에는 둘레를 계산할 수 없음
	}
	*/
	
	public double getArea() {
		return area;
	}
	
	public double getCircum() {
		return circum;
	}
	
}
