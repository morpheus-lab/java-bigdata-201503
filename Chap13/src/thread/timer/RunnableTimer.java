package thread.timer;

public class RunnableTimer implements Runnable {

	int n;
	
	@Override
	public void run() {
		while (true) {
			System.out.println(n++);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		RunnableTimer rt = new RunnableTimer();
		Thread t = new Thread(rt);
		t.start();
	}

}
