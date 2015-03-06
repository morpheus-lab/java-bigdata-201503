import java.io.InputStreamReader;


public class InputExample {
	
	public static void main(String[] args) throws Exception {
		
		InputStreamReader rd = new InputStreamReader(System.in);
		
		while (true) {
			
			int a = rd.read();
			if (a == -1) {	// 더 이상 읽을 데이터가 없는 경우 또는
							// 중단 신호가 온 경우 (<Ctrl>+Z)
				break;
			}
			
			System.out.println((char)a);	// 입력된 문자 출력
			
		}
		
	}
	
}
