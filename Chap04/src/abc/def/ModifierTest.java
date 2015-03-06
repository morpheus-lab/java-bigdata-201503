package abc.def;

import abc.Book;	// 이 클래스와 다른 패키지에 속한 abc.Book 클래스를 가져다 쓰겠다
					// 이 import 구문에 의해 이 클래스에서 "Book"이라는 이름으로 쓰는 클래스는
					// "abc.Book" 클래스를 의미

public class ModifierTest extends Book {
	
	// 필드를 따로 선언하지 않아도
	// 상속을 받는다면, 상위 클래스의 필드, 메소드를 물려받아서 자기 것 처럼 사용 가능
	
//	Book b = new Book();	// import를 쓰지 않았다면, Book은 abc.def.Book을 의미
//	abc.Book b1 = new abc.Book();
	
//	abc.def.Book b2 = new abc.def.Book();	// abc.Book을 import 했다면,
											// 같은 패키지에 있는 Book이라도 full name을 써줘야 함
	
	void test() {
		pub = 0;	// public
		pro = 1;	// protected => 같은 패키지이거나, 상속관계에서 하위 클래스에게만 접근 허용
//		def = 2;	// (default) => 같은 패키지인 경우에만 접근 허용
//		pri = 3;	// private => 그 클래스 내에서만 접근 가능
	}
	
}
