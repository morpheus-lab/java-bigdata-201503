import java.util.Scanner;


public class GoodsArray {
	
	public static void main(String[] args) {
		
		Goods[] goodsArray = new Goods[3];	// 3개의 Goods 객체를 담을 배열 변수
		
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < goodsArray.length; i++) {
			// Goods 객체 1개를 만들기 위한 인자를 입력 받기
			System.out.println("상품 정보를 \"상품명 가격 재고량 판매량\"의 형식으로 입력하세요.");
			String name = sc.next();
			int price = sc.nextInt();
			int numOfStock = sc.nextInt();
			int sold = sc.nextInt();
			Goods g = new Goods(name, price, numOfStock, sold);
			goodsArray[i] = g;
		}
		
		sc.close();	// 키보드 입력 자원 반납
		
		// goodsArray는 총3개의 Goods 객체를 그 요소로 하는 배열
		
		// 조회
		// for-each 구문
		for (Goods g : goodsArray) {
			System.out.print("상품명: " + g.getName() + ", ");
			System.out.print("가격: " + g.getPrice() + ", ");
			System.out.print("재고: " + g.getNumberOfStock() + ", ");
			System.out.println("판매: " + g.getSold());
		}
		
	}
	
}

class Goods {
	// private: 현재 클래스의 외부에서 접근하지 못하도록
	
	private String name;	// 상품명
	private int price;		// 가격
	private int numberOfStock;	// 재고량
	private int sold;	// 판매량
	
	Goods(String n, int p, int nStock, int s) {
		name = n;
		price = p;
		numberOfStock = nStock;
		sold = s;
	}
	
	// get필드명() 이라고 만든 메소드를 "getter"
	// getter 메소드는 필드 값을 조회할 수 있도록 하는 메소드
	
	String getName() {	// 자신의 name 필드에 저장된 데이터를 복사해서 외부로 전달
		return name;
	}
	
	int getPrice() {
		return price;
	}
	
	int getNumberOfStock() {
		return numberOfStock;
	}
	
	int getSold() {
		return sold;
	}
	
}



















