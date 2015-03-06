
public class CircleArea {
	
	public static void main(String[] args) {
		
		final double PI = 3.14;	// 원주율을 상수로 선언
		double radius = 10;	// 원의 반지름
		double circleArea = 0; // 원의 면적
		
		// 원의 면적 계산
		circleArea = PI * radius * radius;
		
		// 원의 면적을 화면에 출력
		System.out.print("원의 면적 = ");	// 내용을 화면에 출력 후 줄 바꿈 하지 않음
		System.out.println(circleArea);
		
	}
	
}
