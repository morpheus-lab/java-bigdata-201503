package system.apis;

import java.util.Random;

public class RandomNumber {
	
	public static void main(String[] args) {
		
		// 난수
		
		// (1)
		Math.random();
		
		// (2)
		// java.util.Random 이용
		Random rd = new Random();
		int i = rd.nextInt(100);	// 0~99
		
	}
	
}
