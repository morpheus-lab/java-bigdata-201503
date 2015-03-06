package staticmember;

class CurrencyConverter {
	private static double rate;	// 원-달러 환율 1098.30원/달러
	
	public static double toDollar(double won) {	// 원화를 달러로
		return won / rate;
	}
	
	public static double toKRW(double dollar) {	// 달러를 원화로
		return dollar * rate;
	}
	
	public static void setRate(double r) {	// 환율 설정
		rate = r;
	}
}

public class StaticMember {
	public static void main(String[] args) {
		CurrencyConverter.setRate(1098.30);
		System.out.println("백만원은 " + CurrencyConverter.toDollar(1000000) + "달러입니다.");
		System.out.println("천달러는 " + CurrencyConverter.toKRW(1000) + "원입니다.");
	}
}
