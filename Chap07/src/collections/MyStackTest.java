package collections;

public class MyStackTest {
	
	public static void main(String[] args) {
		
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
		
	}
	
}
