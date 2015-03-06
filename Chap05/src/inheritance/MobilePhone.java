package inheritance;

public class MobilePhone extends Phone {
	
	// Phone으로부터 물려받는 기능
	// call()
	// answer()
	
	private void test() {	// 물려받은 기능 확인
		this.call("01012341234");
		this.answer();
	}
	
	// 무선 기지국 연결
	public void connectCell() {
		System.out.println("무선 기지국에 연결합니다.");
	}
	
	// 배터리 충전하기
	public void chargeBattery() {
		System.out.println("배터리를 충전합니다.");
	}
	
}
