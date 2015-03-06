
public class LogicalOperator {
	
	public static void main(String[] args) {
		
		// char 타입끼리 비교 => 문자의 코드값을 비교
		System.out.println('a' > 'b');	// false
		System.out.println(3 >= 2);		// true
		System.out.println(-1 < 0);		// true
		System.out.println(3.45 <= 2);	// false
		System.out.println(3 == 2);		// false
		System.out.println(3 != 2);		// true
		System.out.println(!(3 != 2));	// false
		
		// 논리식의 AND, OR, XOR 연산
		System.out.println((3 > 2) && (3 > 4));	// false
		System.out.println((3 != 2) || (-1 > 0));	// true
		System.out.println((3 != 2) ^ (-1 > 0));	// true
		
	}
	
}
