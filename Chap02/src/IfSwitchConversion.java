import java.util.Scanner;	// <Ctrl> + <Shift> + O => 자동 임포트


public class IfSwitchConversion {
	
	public static void main(String[] args) {
		
		char grade;	// 학점
		
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			
			int score = sc.nextInt();	// 사용자 입력 문자열을 int형으로
			
			int s = score / 10;
			
			if (s == 10 || s == 9) {
				grade = 'A';
			} else if (s == 8) {
				grade = 'B';
			} else if (s == 7) {
				grade = 'C';
			} else if (s == 6) {
				grade = 'D';
			} else {
				grade = 'F';
			}
			
//			switch (score / 10) {
//			case 10:
//			case 9:
//				grade = 'A';
//				break;
//			case 8:
//				grade = 'B';
//				break;
//			case 7:
//				grade = 'C';
//				break;
//			case 6:
//				grade = 'D';
//				break;
//			default:
//				grade = 'F';
//			}
			
			System.out.println("학점은 " + grade + "입니다.");
		}
		
		sc.close();	// 키보드 입력 스트림 자원을 OS에 반납
	}
	
}
