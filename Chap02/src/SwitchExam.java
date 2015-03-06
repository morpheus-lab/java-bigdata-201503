
public class SwitchExam {
	
	public static void main(String[] args) {
		
		int a = 0;
		int b = 2;
		
		switch (a) {
		case 0:
			System.out.println("a가 0");
			break;
		case 1:	// case 문에는 리터럴만 지정될 수 있다.
			System.out.println("a가 1");
			break;
		default:
			System.out.println("a가 다른 값");
		}
		
	}
	
}
