package abc;

public class BookStore {
	
	Book b = new Book();
	
	void m() {
		// 접근 지정자 비교
		b.pub = 1;	// abc.Book의 public 멤버변수		// 아무나
		b.pro = 1;	// abc.Book의 protected 멤버변수	// 같은 패키지, 하위클래스
		b.def = 1;	// abc.Book의 (default) 멤버 변수	// 같은 패키지
//		b.pri = 1;	// abc.Book의 private 멤버 변수		// 해당 클래스 내에서만		// 접근 불가
	}
	
}
