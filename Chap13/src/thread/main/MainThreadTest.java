package thread.main;

public class MainThreadTest {
	
	public static void main(String[] args) {
		
		Thread t = Thread.currentThread();	// 현재 이 코드를 실행하는 스레드 객체
		
		String name = t.getName();
		long id = t.getId();
		int p = t.getPriority();
		Thread.State state = t.getState();
		
		System.out.println("이    름: " + name);
		System.out.println("아 이 디: " + id);
		System.out.println("우선순위: " + p);
		System.out.println("상    태: " + state);
		
	}
	
}
