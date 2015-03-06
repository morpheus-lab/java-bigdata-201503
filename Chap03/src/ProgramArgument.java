
public class ProgramArgument {
	
	public static void main(String[] args) {
		
		System.out.println("입력한 프로그램 인자는...");
		
		for (int i = 0; i < args.length; i++) {
			System.out.println(args[i]);
		}
		
		System.out.println("...입니다.");
		
	}
	
}
