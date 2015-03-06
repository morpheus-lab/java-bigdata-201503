
public class Garbage {
	
	String name;
	String[] dummy;
	
	public Garbage(String name) {
		this.name = new String(name);
		this.dummy = new String[10000];
		for (int i = 0; i < this.dummy.length; i++) {
			this.dummy[i] = new String("akshglkdhklghaslghalhdlsahhgalkh");
		}
	}
	public void finalize() {	// 객체 소멸 직전에 호출되는 메소드
		System.out.println(this.name + " 소멸");
	}
	
	public static void main(String[] args) {
		
		Garbage a = new Garbage("객체A");
		Garbage b = new Garbage("객체B");
		Garbage c = new Garbage("객체C");
		
		a = null;	// 객체A에 대한 레퍼런스가 모두 사라짐
		
		System.gc();	// 가비지 컬렉션 실행 요청
		
		Garbage d = c;	// 객체C에 대한 레퍼런스가 d에 추가
		
		c = null;	// 객체C에 대한 레퍼런스 1개 사라짐
		
		System.gc();	// 가비지 컬렉션 실행 요청
		
	}
	
}
