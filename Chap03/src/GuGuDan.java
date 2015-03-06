
public class GuGuDan {
	
	public static void main(String[] args) {
		
		L_DAN:
		for (int dan = 2; dan < 10; dan++) {
			
			// dan * 1
			// dan * 2
			
			for (int i = 1; i < 10; i++) {
				
				if (i == 6) {
					continue L_DAN;
				}
				
				System.out.println(dan + " * " + i + " = " + (dan * i));
				
//				if (i == 6) {
//					break L_DAN;
//				}
				
			}
			
			System.out.println();
			
		}
		
	}
	
}
