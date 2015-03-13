package thread.videoshop;

public class Customer extends Thread {

	@Override
	public void run() {
		String video = null;
		// 비디오 빌리기
		video = VideoShopMain.vShop.lendVideo();
		System.out.println(Thread.currentThread().getName()
				+ ": " + video + "을/를 빌렸습니다.");

		// 비디오 보기
		System.out.println(Thread.currentThread().getName()
				+ ": 비디오를 봅니다.");
		try {
			sleep(5000);
		} catch (InterruptedException e) {
		}

		// 비디오 반납하기
		VideoShopMain.vShop.returnVideo(video);
		System.out.println(Thread.currentThread().getName()
				+ ": 비디오를 반납했습니다.");
	}
}

