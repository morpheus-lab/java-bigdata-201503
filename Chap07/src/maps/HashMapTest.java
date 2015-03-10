package maps;

import java.util.HashMap;
import java.util.Set;

public class HashMapTest {
	
	public static void main(String[] args) {
		
		HashMap<String, String> map = new HashMap<String, String>();	// 키-값 쌍이 저장되는 자료구조
																		// String 타입의 키, String 타입의 값을 저장
		map.put("apple", "사과");
		map.put("love", "사랑");
		map.put("baby", "아기");
		
		System.out.println(map);
		
		// V get(K key) - 인자로 전달된 키 객체로 저장된 값 객체 리턴
		String value = map.get("love");
		System.out.println(value);
		
		map.put("baby", "베이비");	// 키가 이미 존재하는 경우, 값을 덮어 씀
		
		System.out.println(map);
		
		// void clear()
		
		// contains
		System.out.println(map.containsKey("apple"));
		System.out.println(map.containsValue("망고"));
		
		// boolean isEmpty()
		
		// Set<K> keySet()
		Set<String> keys = map.keySet();
		
		// V remove(Object key) - 맵으로부터 key로 저장된 데이터를 삭제, 삭제된 데이터의 값을 리턴
		System.out.println("remove() ---------------------");
		String removed = map.remove("apple");
		System.out.println(removed);
		System.out.println(map);
		
		// int size() - 저장된 요소의 개수 리턴
		System.out.println(map.size());
		
	}
	
}

























