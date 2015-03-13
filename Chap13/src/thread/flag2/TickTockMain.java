package thread.flag2;

import java.util.Scanner;

public class TickTockMain {
	
	public static void main(String[] args) {
		
		System.out.println("main ����");
		
		TickTockThread a = new TickTockThread();
		a.setName("A");
		TickTockThread b = new TickTockThread();
		b.setName("B");
		TickTockThread c = new TickTockThread();
		c.setName("C");
		
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("[������ ����: SA/SB/SC, ������ ����: TA/TB/TC/TM]");
			System.out.println("��ɾ �Է��ϼ���.");
			
			String command = sc.nextLine();
			
			if (command.equalsIgnoreCase("sa")) {
				if (a.getState().equals(Thread.State.NEW))
					a.start();
				else
					System.out.println("�̹� ���۵Ǿ���");
			} else if (command.equalsIgnoreCase("sb")) {
				if (b.getState().equals(Thread.State.NEW))
					b.start();
			} else if (command.equalsIgnoreCase("sc")) {
				if (c.getState() == Thread.State.NEW)
					c.start();
			} else if (command.equalsIgnoreCase("ta")) {
				a.interrupt();
			} else if (command.equalsIgnoreCase("tb")) {
				b.terminate();
			} else if (command.equalsIgnoreCase("tc")) {
				c.interrupt();
			} else if (command.equalsIgnoreCase("tm")) {
				a.terminate();
				b.terminate();
				c.terminate();
				break;
			}
			
		}
		
		sc.close();
		
		System.out.println("A����: " + a.getState());
		
		System.out.println("main ����");
	}
	
}
