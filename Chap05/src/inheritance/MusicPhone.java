package inheritance;

public class MusicPhone extends MobilePhone {
	
	// MobilePhone으로 부터 물려받은 기능
	// call() - Phone으로부터 물려받은 기능
	// answer() - Phone으로부터 물려받은 기능
	// connectCell()
	// chargeBattery()
	
	private void test() {
		this.call("01012345678");
		this.answer();
		this.connectCell();
		this.chargeBattery();
	}
	
	// 음악 다운로드
	public void downloadMusic() {
		System.out.println("음악을 다운로드합니다.");
	}
	
	// 음악 재생
	public void playMusic() {
		System.out.println("음악을 재생합니다.");
	}
	
}
