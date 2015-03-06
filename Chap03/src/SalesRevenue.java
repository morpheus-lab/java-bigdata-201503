
public class SalesRevenue {
	
	public static void main(String[] args) {
		
		int[][] sales = {
				{90, 90, 110, 110},		// 1차년도 분기별 매출
				{120, 110, 100, 110},	// 2차년도 분기별 매출
				{120, 140, 130, 150}	// 3차년도 분기별 매출
		};
		
		double sum = 0;	// 매출 총합
		
		for (int i = 0; i < sales.length; i++) {	// 1개년도에 대한 작업
			// i == 0 이라면 sales[i] = {90, 90, 110, 110}
			for (int j = 0; j < sales[i].length; j++) {	// 각 분기에 대한 작업
				sum += sales[i][j];
			}
		}
		// sum에 모든 매출 합계가 저장됨
		
		System.out.println("3년간 총 매출액: " + sum + ", 연평균 매출액: " + (sum / sales.length));
		
	}
	
}
