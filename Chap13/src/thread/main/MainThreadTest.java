package thread.main;

public class MainThreadTest {
	
	public static void main(String[] args) {
		
		Thread t = Thread.currentThread();	// ���� �� �ڵ带 �����ϴ� ������ ��ü
		
		String name = t.getName();
		long id = t.getId();
		int p = t.getPriority();
		Thread.State state = t.getState();
		
		System.out.println("��    ��: " + name);
		System.out.println("�� �� ��: " + id);
		System.out.println("�켱����: " + p);
		System.out.println("��    ��: " + state);
		
	}
	
}
