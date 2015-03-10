package collections;

import java.util.Vector;

public class VectorTest {
	
	public static void main(String[] args) {
		
		Vector<Integer> v = new Vector<Integer>();
		
//		System.out.println("용량: " + v.capacity());	// 초기값: 10
		
		System.out.println("사이즈: " + v.size());
		
		v.add(new Integer(1));	// 인덱스 0번 위치
		System.out.println("사이즈: " + v.size());
		
		v.add(new Integer(3));	// 인덱스 1번 위치
		System.out.println("사이즈: " + v.size());
		
		v.add(5);				// 인덱스 2번 위치
		System.out.println("사이즈: " + v.size());
		
//		System.out.println(v);
		
		v.add(1, new Integer(7));	// 인덱스 1번 위치에 삽입
		System.out.println("사이즈: " + v.size());
		
		System.out.println(v);
		
		Integer element = v.get(2);
		System.out.println(element);
		
		// 요소 삭제
		v.remove(0);
		System.out.println(v);
//		System.out.println(v.get(3));	// 예외 발생
		
		v.firstElement();	// 첫번째 요소를 조회
		v.lastElement();	// 마지막 요소를 조회
		
		v.removeAllElements();	// 모든 요소를 삭제
		
		for (int i = 1; i <= 100; i++) {
			v.add(i);
			System.out.println(v + " (용량: " + v.capacity() + ")");
		}
		
		v.removeAllElements();	// 저장된 요소만 삭제, 용량은 그대로 유지
		
		System.out.println(v + " (용량: " + v.capacity() + ")");
		
	}
	
}
