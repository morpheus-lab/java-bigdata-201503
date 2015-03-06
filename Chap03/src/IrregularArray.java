
public class IrregularArray {
	
	public static int[] init() {
		int[] a = new int[4];
		for (int i = 0; i < a.length; i++) {
			a[i] = i;
		}
		return a;
	}
	
	public static void main(String[] args) {
		
		int[] arr = init();
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		/*
		// 블록 주석 지정: 블록을 지정한 다음 <Ctrl>+<Shift>+/
		// 블록 주석 해제: <Ctrl>+<Shift>+\
		int[][] arr = new int[4][];
		
		arr[0] = new int[3];	// 10, 11, 12
		arr[1] = new int[2];	// 20, 21
		arr[2] = new int[3];	// 30, 31, 32
		arr[3] = new int[2];	// 40, 41
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = (i + 1) * 10 + j;
			}
		}
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++, System.out.print('\t')) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		*/
		
	}
	
}
