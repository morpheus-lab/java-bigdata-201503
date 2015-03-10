package maps;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

class Student {
	int id;			// 학번
	String tel;		// 전화번호
	String name;	// 이름
	String dept;	// 학과
	
	public Student(int id, String tel, String name, String dept) {
		this.id = id;
		this.tel = tel;
		this.name = name;
		this.dept = dept;
	}
	
	public String toString() {	// Object의 toString() 메소드를 재정의(overriding)
		return "(" + id + "," + tel + "," + dept + ")";
	}
}

public class StudentInfo {
	
	public static void main(String[] args) {
		
		// 학생 정보를 저장할 Map 객체 생성
		HashMap<String, Student> infos = new HashMap<String, Student>();
		
		infos.put("홍길동", new Student(1001, "010-1111-1111", "홍길동", "컴공"));
		infos.put("심청", new Student(1002, "010-2222-2222", "심청", "국악"));
		infos.put("이몽룡", new Student(1006, "010-3000-3000", "이몽룡", "행정"));
		
		System.out.println(infos);
		
		// 맵에 저장된 모든 요소를 순차적으로 접근
		Set<String> keys = infos.keySet();
		// 키에 대한 Iterator 객체
		Iterator<String> keyIter = keys.iterator();
		while(keyIter.hasNext()) {
			String key = keyIter.next();	// 다음 키 꺼내고
			Student value = infos.get(key);	// 맵에서 위에서 꺼낸 키로 값 조회
			System.out.println(key + ": " + value);
		}
		
	}
	
}






















