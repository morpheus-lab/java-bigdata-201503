package system.apis;

public class Lotto645 {
	
	public static void main(String[] args) {
		
		int[] luckyNums = new int[6];
		
		for (int i = 0; i < luckyNums.length; i++) {
			luckyNums[i] = (int) (Math.random() * 45 + 1);
			for (int j = 0; j < i; j++) {
				if (luckyNums[j] == luckyNums[i]) {
					i--;
					break;
				}
			}
		}
		
		for (int i = 0; i < luckyNums.length; i++) {
			System.out.println(luckyNums[i]);
		}
		
	}
	
}
