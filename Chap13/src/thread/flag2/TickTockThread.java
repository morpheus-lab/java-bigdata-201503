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
		System.out.println(threadName + ": ����");
		
		while (!stopFlag) {
			try {
				sleep(100);
			} catch (InterruptedException e) {	// interrupt() ȣ���ϸ� InterruptedException �߻�
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
						+ ": ���ͷ�Ʈ ��");
				break;
			}
			*/
		}
		
		System.out.println(threadName + ": " + (stopFlag ? "terminate()�� " : "interrupt()�� ") + "����");
	}
	
}
