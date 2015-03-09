package inheritance.constructor;

public class C extends B{
	
	public C() {
		// super();
		System.out.println("C 생성자 호출됨");
	}
	
	public C(int a) {
		// super();
		super(a);	// 상위 클래스의 파라미터 있는 생성자를 명시적으로 호출
		System.out.println("C 파라미터 있는 생성자 호출됨");
	}
	
}
