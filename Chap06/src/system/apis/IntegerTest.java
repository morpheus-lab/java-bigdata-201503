package system.apis;

public class IntegerTest {
	
	public static void main(String[] args) {
		/*
		Integer i = new Integer(5);
		
		System.out.println(Integer.bitCount(5));
		
		int i2 = Integer.parseInt("2000");
		
		System.out.println(Integer.parseInt("50", 10));
		System.out.println(Integer.parseInt("50", 8));
		System.out.println(Integer.parseInt("50", 16));
		*/
		
		int i = 100;
		
		String binary = Integer.toBinaryString(i);
		String octal = Integer.toOctalString(i);
		String hex = Integer.toHexString(i);
		String str = Integer.toString(i);
		
		System.out.println(binary);
		System.out.println(octal);
		System.out.println(hex);
		System.out.println(str);
		
		
	}
	
}
