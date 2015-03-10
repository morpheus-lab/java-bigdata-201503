package collections;

class Student {
	int id;	// 학번
	String name;	// 이름
	
	public void sayName() {
		System.out.println(name);
	}
}

public class MyStackTest {
	
	public static void main(String[] args) {
		
		MyStack<Student> stack2 = new MyStack<Student>();
		
		Student s = new Student();
		s.id = 1000;
		s.name = "홍길동";
		
		stack2.push(s);
		
		/*
		MyStack<String> stack1 = new MyStack<String>();
		
		stack1.push("한국");
		stack1.push("일본");
		stack1.push("미국");
		stack1.push("중국");
		stack1.push("대만");
		stack1.push("인도");
		stack1.push("프랑스");
		stack1.push("영국");
		
		System.out.println(stack1.pop());	// "영국"
		System.out.println(stack1.pop());	// "프랑스"
		System.out.println(stack1.pop());	// "인도"
		
		stack1.push("스리랑카");
		stack1.push("미얀마");
		stack1.push("태국");
		stack1.push("라오스");
		stack1.push("베트남");
		stack1.push("캄보디아");	// 가득찬 이후에 push했기 때문에 무시됨
		
		System.out.println(stack1.pop());
		*/
		
	}
	
}
