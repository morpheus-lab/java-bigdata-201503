import java.util.Scanner;

/**
 * 사용자로부터 숫자를 5개 입력받고,
 * 가장 큰 숫자를 출력하는 예제
 */
public class ArrayMaxNum {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int[] intArray = new int[10];
		int max = 0;
		
		for (int i = 0; i < intArray.length; i++) {
			System.out.print("양의 정수를 입력하세요: ");
			intArray[i] = sc.nextInt();
			
			if (intArray[i] > max) {
				max = intArray[i];
			}
		}
		
		// 가장 큰 수 찾기
//		for (int i = 0; i < 5; i++) {
//			if (intArray[i] > max) {
//				max = intArray[i];
//			}
//		}
		
		System.out.println("입력한 숫자 중 가장 큰 수는: " + max);
		
//		System.out.println(intArray[6]);
		
		// 배열 인덱스의 최소값: 0
		// 배열 인덱스의 최대값: 배열의 크기 - 1
		int size = intArray.length;	// 배열의 크기
		System.out.println("intArray 배열의 크기는: " + size);
		
	}
	
}
