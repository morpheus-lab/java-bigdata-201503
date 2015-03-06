import java.util.Scanner;


public class ExceptionTest {
	
	public static void main(String[] args) {
		
		String s = "1abc";
		int a = Integer.parseInt(s);	// 문자열을 int형 자료로 변환
		System.out.println(a);
		
		/*
		Scanner sc = new Scanner(System.in);
		int a = 0;
		int b = 0;
		
		System.out.print("첫번째 수: ");
		a = sc.nextInt();
		
		System.out.print("두번째 수: ");
		b = sc.nextInt();
		
		try {
			System.out.println("첫번째 수 / 두번째 수 = " + (a / b));
		} catch (ArithmeticException e) {
			// ArithmeticException 타입의 예외가 발생하면 어찌어찌 처리하겠다
			System.out.println("산술적 예외 상황이 발생했군요...");
		}
		// finally 구문은 생략 가능
		finally {
			// 예외가 발생하지 않을 때,
			// 발생할 때
			// 모든 경우에 실행할 구문
		}
		
		System.out.println("프로그램 종료");
		*/
	}
	
}
