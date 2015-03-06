package staticmember;

class StaticSample {
	// non-static 멤버 / 인스턴스 멤버
	public int n;
	public void g() {
		m = 20;
	}
	public void h() {
		m = 30;
	}
	
	// static 멤버 / 클래스 멤버
	public static int m;
	public static void f() {
		m = 5;
	}
}

public class StaticExam {
	
	public static void main(String[] args) {
		/*
		StaticSample s1 = new StaticSample(), s2 = new StaticSample();
		
		s1.n = 5;	// 인스턴스 변수 n의 값을 5로 변경
		s1.g();		// 인스턴스 메소드 g를 호출
		s1.m = 50;	// static - 클래스 변수 m의 값을 50으로 변경
		
		s2.n = 8;
		s2.h();
		s2.f();		// static
		
		System.out.println(s1.m);
		*/
		
		StaticSample.m = 10;
		
		StaticSample s1 = new StaticSample();
		System.out.println(s1.m);
		s1.f();
		
		StaticSample.f();
		
	}
	
}
