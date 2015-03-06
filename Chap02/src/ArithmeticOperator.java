import java.util.Scanner;

/*
 * 정수를 입력 받고 입력 받은 초 단위의 정수를
 * 몇 분 몇 초인가를 구하는 프로그램
 */
public class ArithmeticOperator {
	
	public static void main(String[] args) {
		
		int time;	// 3672 (1h 1m 12s)
		int second;	// 12
		int minute;	// 1
		int hour;	// 1
		
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력하세요: ");
		
		time = sc.nextInt();	// 사용자가 입력한 문자열을 int형 정수로 변환해서 time에 저장
		second = time % 60;
		minute = (time / 60) % 60;
		hour = time / 60 / 60;
		
		System.out.print(time + "초는 ");
		System.out.print(hour + "시간, ");
		System.out.print(minute + "분, ");
		System.out.println(second + "초 입니다.");
	}
	
}
