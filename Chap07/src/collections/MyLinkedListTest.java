package collections;

public class MyLinkedListTest {
	
	public static void main(String[] args) {
		
		MyLinkedList<Integer> list = new MyLinkedList<Integer>();
		
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		
//		System.out.println(list.get(0));
//		System.out.println(list.get(2));
//		System.out.println(list.get(3));
//		System.out.println(list.get(4));	// 예외발생!
		
		list.add(2, 5);	// 2번 인덱스 위치에 새 데이터 5 삽입
		
//		System.out.println(list.get(0));
//		System.out.println(list.get(1));
//		System.out.println(list.get(2));
//		System.out.println(list.get(3));
//		System.out.println(list.get(4));
		
		list.add(1, 6);
		
//		System.out.println(list.get(0));
//		System.out.println(list.get(1));
//		System.out.println(list.get(2));
//		System.out.println(list.get(3));
//		System.out.println(list.get(4));
//		System.out.println(list.get(5));
		
		list.add(6, 7);
		
//		System.out.println(list.get(0));
//		System.out.println(list.get(1));
//		System.out.println(list.get(2));
//		System.out.println(list.get(3));
//		System.out.println(list.get(4));
//		System.out.println(list.get(5));
//		System.out.println(list.get(6));
		
//		list.add(8, 8);	// 6번 인덱스까지 데이터가 저장되어 있는 상태에서
						// 7번을 건너뛰고 8번 인덱스에 저장하려하면
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
	}
	
}
















