package thread.flag2;

public class TickTockThread extends Thread {
	
	private boolean stopFlag = false;
	
	public void terminate() {
		stopFlag = true;
	}
	
	@Override
	public void run() {
		Thread currentThread = Thread.currentThread();
		String threadName = currentThread.getName();
		System.out.println(threadName + ": 시작");
		
		while (!stopFlag) {
			try {
				sleep(100);
			} catch (InterruptedException e) {	// interrupt() 호출하면 InterruptedException 발생
				break;
			}
			/*
			Thread currentThread = Thread.currentThread();
			System.out.println(currentThread.getName()
					+ ": Tick");
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				System.out.println(currentThread.getName()
						+ ": 인터럽트 됨");
				break;
			}
			*/
		}
		
		System.out.println(threadName + ": " + (stopFlag ? "terminate()로 " : "interrupt()로 ") + "종료");
	}
	
}
