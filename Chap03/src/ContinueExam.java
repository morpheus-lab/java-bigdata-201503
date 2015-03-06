
public class ContinueExam {
	
	public static void main(String[] args) {
		
		// 1 ~ 100 정수 중 짝수의 합
		
		int sum = 0;
		
		for (int i = 1; i <= 100; i++) {
			
			if (i % 2 == 1) {	// 홀수이면
				continue;	// 건너뛰기
			}
			
			// 합계에 누적
			sum += i;	// 2, 4, 6, 8, 10, ...
		}
		
		System.out.println("1~100 사이의 짝수 합: " + sum);
		
	}
	
}
