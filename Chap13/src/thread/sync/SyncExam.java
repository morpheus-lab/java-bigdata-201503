package thread.sync;

public class SyncExam {
	
	public static void main(String[] args) {
		
		SyncObject sObj = new SyncObject();
		WorkerThread t1 = new WorkerThread("1¹ø", sObj);
		WorkerThread t2 = new WorkerThread("2¹ø", sObj);
		
		t1.start();
		t2.start();
	}
	
}

class SyncObject  {
	private int sum;
	public /*synchronized*/ void add() {
		int n = sum;
		Thread.yield();
		n += 10;
		sum = n;
		System.out.println(Thread.currentThread().getName() + ": " + sum);
	}
	public int getSum() {
		return sum;
	}
}

class WorkerThread extends Thread {
	SyncObject sObj;
	
	public WorkerThread(String name, SyncObject sObj) {
		super(name);
		this.sObj = sObj;
	}
	
	@Override
	public void run() {
		int i = 0;
		while (i < 10) {
			sObj.add();
			i++;
		}
	}
}
























