import java.io.IOException;
import java.io.InputStream;


public class ShiftExample {
	
	public static void main(String[] args) throws IOException {
		
		InputStream sysIn = System.in;
		
		int b = 0;
		while (true) {
			b = sysIn.read();
			if (b == -1) {
				break;
			}
			System.out.println((char)b);
		}
		
	}
	
}
