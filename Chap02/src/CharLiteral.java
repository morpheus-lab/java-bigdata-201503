
public class CharLiteral {
	
	public static void main(String[] args) {
		
		char c = 'a';
		
		System.out.println(c);
		
		c = '\u0061';	// 영문자는 ASCII 코드로
		
		System.out.println(c);
		
		c = '\b';
		
		System.out.println("A" + c + "B");
		
	}
	
}
