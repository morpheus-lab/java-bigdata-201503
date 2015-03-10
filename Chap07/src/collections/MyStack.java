package collections;

public class MyStack<T> {
	
	Object[] stack;	// 내부적으로 사용될 데이터 저장용 배열
//	T[] stack;
	int top = 0;	// 다음 데이터가 들어갈 배열 인덱스
	
	public MyStack() {
		this(10);
	}
	
	public MyStack(int capacity) {
		stack = new Object[capacity];	// 내부 저장용 배열을 생성
//		stack = new T[capacity];
	}
	
	// 스택에 데이터를 저장
	public void push(T item) {
		if (top == stack.length)	// 이 스택의 내부 저장용 배열이 가득찬 경우
			return;
		
		stack[top++] = item;	// 1번째 데이터는 stack[0]
								// 2번째 데이터는 stack[1]
								// n번째 데이터는 stack[n-1]
	}
	
	// 스택으로부터 데이터를 꺼냄
	public T pop() {
		// 스택이 비어 있다면?
		if (top == 0)
			return null;
		
		top--;
		return (T) stack[top];
	}
}
























