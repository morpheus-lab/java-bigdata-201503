import java.util.Scanner;


public class BreakExam {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int num = 0;
		
		while (true) {
			if (sc.nextInt() == -1) {	// 키보드로 입력한 값이 -1이라면
				break;	// 반복을 중단, while문을 빠져나감
			}
			num++;
		}
		
		System.out.println("입력된 숫자의 개수는 " + num + "개입니다.");
		
		sc.close();
		
	}
	
}
