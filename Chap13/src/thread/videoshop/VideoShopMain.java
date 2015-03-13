package thread.videoshop;

public class VideoShopMain {
	
	static VideoShop vShop = new VideoShop();	
	
	public static void main(String[] args) {
		Customer c1 = new Customer();
		Customer c2 = new Customer();
		Customer c3 = new Customer();
		Customer c4 = new Customer();
		Customer c5 = new Customer();
		c1.start();
		c2.start();
		c3.start();
		c4.start();
		c5.start();
	}
	
}
