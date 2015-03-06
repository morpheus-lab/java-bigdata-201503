
public class ForExam {
	
	public static void main(String[] args) {
		
//		int i;
		for (int i = 0; i < 10; i++) {
			System.out.print(i);
			System.out.println("~");
		}
		
		// 1 ~ 100까지의 합
		int sum = 0;
		for (int i = 1; i <= 100; i++) {
			sum += i;	// sum = sum + i;
		}
		
		sum = 0;
		for (int i = 100; i >= 1; i--) {
			sum += i;
		}
	}
	
}
