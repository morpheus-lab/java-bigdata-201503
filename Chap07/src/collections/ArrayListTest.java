package collections;

import java.util.ArrayList;
import java.util.Vector;

public class ArrayListTest {
	
	public static void main(String[] args) {
		
		Vector<String> v1 = new Vector<String>();
		v1.add("Grape");
		v1.add("Strawberry");
		
		ArrayList<String> list1 = new ArrayList<String>();
		
		list1.add("Apple");
		list1.add("Mango");
		list1.add("Orange");
		
		// boolean addAll(Collection<> c)
		ArrayList<String> list2 = new ArrayList<String>();
		
		list2.addAll(list1);	// list1 객체에 저장된 요소를 한꺼번에 추가
		System.out.println(list2);
		
		list2.addAll(v1);	// v1 객체에 저장된 요소를 한꺼번에 추가
		System.out.println(list2);
		
		// clear() - 모든 요소 삭제
		list2.clear();
		System.out.println(list2);
		
		// boolean contains(Object o) - 인자로 전달된 객체의 존재 여부
		System.out.println(list1.contains("Apple"));
		System.out.println(list1.contains("Grape"));
		
		// E get(int index) - index 위치에 있는 요소 조회
		System.out.println(list1.get(2));
		
		// int indexOf(Object o) - 인자로 전달된 객체의 위치(인덱스) 조회
		int indexOfMango = list1.indexOf("Mango");	// 객체가 없을 경우 -1 리턴
		
		// boolean isEmpty() - 리스트가 비어 있는지 여부
		boolean empty = list1.isEmpty();
		
		// E remove(int index) - index 위치에 있는 요소를 삭제하고 그 요소를 리턴
		String removedElement = list1.remove(1);
		
		// boolean remove(Object o) - 인자로 전달된 객체를 리스트로 부터 삭제하고, 삭제 여부 리턴
		boolean removed = list1.remove("Strawberry");
		
		// int size() - 리스트에 저장된 요소의 개수
		int size = list1.size();
		
		// Object[] toArray() - 리스트에 저장된 요소들을 Object 배열로 리턴
		Object[] arr = list1.toArray();
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		// E[] toArray(E[] a)
		String[] strArr = new String[list1.size()];
		System.out.println("=== toArray 전 ===");
		for (String s : strArr) {
			System.out.println(s);
		}
		
		list1.toArray(strArr);
		System.out.println("=== toArray 후 ===");
		for (String s : strArr) {
			System.out.println(s);
		}
		
	}
	
}

















