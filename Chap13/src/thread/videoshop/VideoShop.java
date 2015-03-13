package thread.videoshop;

import java.util.ArrayList;

public class VideoShop {
	
	// 비디오 테이프를 저장하는 곳
	ArrayList<String> vTapeList = new ArrayList<String>();
	
	public VideoShop() {
		vTapeList.add("킹스맨 - 1");
		vTapeList.add("킹스맨 - 2");
//		vTapeList.add("킹스맨 - 3");
	}
	
	synchronized String lendVideo() {
		while (vTapeList.size() < 1) {
			System.out.println(Thread.currentThread().getName() + ": 대기...");
			try {
				this.wait();	// 현재 이 코드를 실행하는 스레드를 WAITING 상태로 만듦
			} catch (InterruptedException e) {}
			System.out.println(Thread.currentThread().getName() + ": 대기해제!");
		}
		
		return vTapeList.remove(vTapeList.size() - 1);
	}
	
	synchronized void returnVideo(String video) {
		vTapeList.add(video);
		this.notifyAll();
	}
	
}
