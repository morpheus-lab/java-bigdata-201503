package thread.flag2;

enum MyEnum {
	
	A, B, C
	
}

public class EnumTest {
	
	
	public static void main(String[] args) {
		MyEnum a = MyEnum.A;
		
		a = MyEnum.B;
		
		// °ª ºñ±³
		System.out.println(a == MyEnum.A);
		System.out.println(a == MyEnum.B);
		System.out.println(a);
		
		System.out.println(MyEnum.A.ordinal());
		System.out.println(MyEnum.B.ordinal());
		System.out.println(MyEnum.C.ordinal());
		
	}
	
}