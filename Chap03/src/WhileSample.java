import java.util.Scanner;


public class WhileSample {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = 0;
		double sum = 0;
		int i = 0;
		
		while ((i = sc.nextInt()) != 0) {	// 사용자가 0을 입력하지 않았다면 계속 반복
			sum += i;	// 사용자 입력 숫자 누적 합계
			n++;	// 숫자가 몇개 입력되었는지 카운트
		}
		
		System.out.println("입력된 숫자는 총 " + n + "개이고, 평균은 " + (sum / n) + "입니다.");
		
		
		
	}
	
}
