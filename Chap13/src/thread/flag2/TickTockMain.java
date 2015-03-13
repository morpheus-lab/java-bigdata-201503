package thread.flag2;

import java.util.Scanner;

public class TickTockMain {
	
	public static void main(String[] args) {
		
		System.out.println("main 시작");
		
		TickTockThread a = new TickTockThread();
		a.setName("A");
		TickTockThread b = new TickTockThread();
		b.setName("B");
		TickTockThread c = new TickTockThread();
		c.setName("C");
		
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("[스레드 시작: SA/SB/SC, 스레드 종료: TA/TB/TC/TM]");
			System.out.println("명령어를 입력하세요.");
			
			String command = sc.nextLine();
			
			if (command.equalsIgnoreCase("sa")) {
				if (a.getState().equals(Thread.State.NEW))
					a.start();
				else
					System.out.println("이미 시작되었음");
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
		
		System.out.println("A상태: " + a.getState());
		
		System.out.println("main 종료");
	}
	
}
