package thread.videoshop;

public class Customer extends Thread {

	@Override
	public void run() {
		String video = null;
		// ���� ������
		video = VideoShopMain.vShop.lendVideo();
		System.out.println(Thread.currentThread().getName()
				+ ": " + video + "��/�� ���Ƚ��ϴ�.");

		// ���� ����
		System.out.println(Thread.currentThread().getName()
				+ ": ������ ���ϴ�.");
		try {
			sleep(5000);
		} catch (InterruptedException e) {
		}

		// ���� �ݳ��ϱ�
		VideoShopMain.vShop.returnVideo(video);
		System.out.println(Thread.currentThread().getName()
				+ ": ������ �ݳ��߽��ϴ�.");
	}
}

