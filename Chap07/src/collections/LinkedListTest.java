package collections;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListTest {
	
	public static void main(String[] args) {
		
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		
		System.out.println(list);
		
		System.out.println("head: " + list.getFirst());	// 맨 앞 데이터	(head)
		System.out.println("tail: " + list.getLast());		// 맨 뒤 데이터 (tail)
		
		System.out.println("=== Iterator ===");
		Iterator<Integer> iter = list.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		System.out.println("=== Iterator (reverse) ===");
		iter = list.descendingIterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		System.out.println("=== ListIterator ==="); // 양방향 탐색이 가능함
		ListIterator<Integer> listIter = list.listIterator();
		if (listIter.hasNext()) {		// 커서 뒤에 요소가 있는가?
			listIter.next();
		}
		if (listIter.hasPrevious()) {	// 커서 앞에 요소가 있는가?
			listIter.previous();
		}
		
	}
	
}
