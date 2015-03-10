package collections;

import java.util.Collections;
import java.util.LinkedList;

public class CollectionsTest {
	
	
	
	public static void main(String[] args) {
		
		LinkedList<String> list = new LinkedList<String>();
		list.add("트랜스포머");
		list.add("스타워즈");
		list.add("어벤저스");
		list.add("매트릭스");
		
		System.out.println("sort전: " + list);
		
		Collections.sort(list);
		
		System.out.println("sort후: " + list);
		
		Collections.reverse(list);
		
		System.out.println("reverse후: " + list);
		
		int index = Collections.binarySearch(list, "스타워즈");
		System.out.println("스타워즈는 " + index + "번 인덱스에 위치");
		
		/*
		Returns the index of the search key,
		if it is contained in the list;
		otherwise, (-(insertion point) - 1).
		The insertion point is defined
		as the point at which the key would be inserted into the list:
		the index of the first element greater than the key,
		or list.size() if all elements in the list are less than
		the specified key.
		Note that this guarantees that the return value will be >= 0
		if and only if the key is found.
		*/
	}
	
}
