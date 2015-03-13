package thread.videoshop;

import java.util.ArrayList;

public class VideoShop {
	
	// ���� �������� �����ϴ� ��
	ArrayList<String> vTapeList = new ArrayList<String>();
	
	public VideoShop() {
		vTapeList.add("ŷ���� - 1");
		vTapeList.add("ŷ���� - 2");
//		vTapeList.add("ŷ���� - 3");
	}
	
	synchronized String lendVideo() {
		while (vTapeList.size() < 1) {
			System.out.println(Thread.currentThread().getName() + ": ���...");
			try {
				this.wait();	// ���� �� �ڵ带 �����ϴ� �����带 WAITING ���·� ����
			} catch (InterruptedException e) {}
			System.out.println(Thread.currentThread().getName() + ": �������!");
		}
		
		return vTapeList.remove(vTapeList.size() - 1);
	}
	
	synchronized void returnVideo(String video) {
		vTapeList.add(video);
		this.notifyAll();
	}
	
}
