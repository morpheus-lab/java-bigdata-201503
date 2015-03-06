package abc;

public class Book {

	public int pub;
	protected int pro;
	int def;
	private int pri;
	
	void test() {
		// 자기 자신 클래스의 멤버 변수라서 아래 모두 가능
		pub = 1;
		pro = 1;
		def = 1;
		pri = 1;
	}
	
}
