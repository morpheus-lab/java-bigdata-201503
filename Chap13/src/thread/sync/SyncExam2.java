package thread.sync;

class AThread extends Thread {
	
	SharedObj o;
	
	public AThread(SharedObj o) {
		this.o = o;
	}
	
	@Override
	public void run() {
		while (true) {
			o.m2();
			o.m1();
		}
	}
	
}

class SharedObj {
	
	static Object lockObj = new Object();
	
	synchronized void m1() {
		System.out.println(Thread.currentThread().getId() + ": m1()");
	}
	
	void m2() {
		System.out.println(Thread.currentThread().getId() + ": m2() Ω√¿€");
		synchronized (lockObj) {
			m1();
		}
		System.out.println(Thread.currentThread().getId() + ": m2() ≥°");
	}
	
}

public class SyncExam2 {
	
	public static void main(String[] args) {
		SharedObj o = new SharedObj();
		AThread a = new AThread(o);
		AThread b = new AThread(o);
		
		a.start();
		b.start();
	}
	
}
