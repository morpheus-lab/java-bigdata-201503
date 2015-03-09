package inheritance.constructor;

public class B extends A {
	
	public B() {
		// super();	// 컴파일러에 의해 자동 삽입
		super(1);	// 상위 클래스 생성자 호출은 생성자의 가장 첫 코드가 되어야 함
		System.out.println("B의 생성자 호출됨");
	}
	
	public B(int a) {
		// super();
		super(a);	// A 클래스의 파라미터 있는 생성자를 명시적으로 호출
		System.out.println("B의 파라미터 있는 생성자 호출됨");
	}
	
}
