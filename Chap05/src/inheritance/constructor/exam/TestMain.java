package inheritance.constructor.exam;

class A {
	
	int i;
	protected int j;
	private String name;
	public int k;
	
	public A() {
		
	}
	
	public A(int a) {
		
	}
	
	public A(int i, int j) {
		
	}
	
}

class B extends A {
	
}

public class TestMain {
	
	public static void main(String[] args) {
		
//		B b = new B(0);	// A 클래스 생성자는 B 클래스가 가지고 있는 것 처럼 사용 불가
//		
//		b.i = 1;	// A 클래스 멤버는 B 클래스가 가지고 있는 것 처럼 사용 가능
//		b.j = 2;
//		b.k = 3;
		
	}
	
}
