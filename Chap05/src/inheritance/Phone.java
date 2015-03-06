package inheritance;

// Phone
// MobilePhone
// MusicPhone

public class Phone {
	
	// 전화 걸기
	public void call(String telNum) {
		System.out.println(telNum + "번으로 전화를 겁니다.");
	}
	
	// 전화 받기
	public void answer() {
		System.out.println("전화를 받습니다.");
	}
	
}
