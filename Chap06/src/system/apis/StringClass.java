package system.apis;

public class StringClass {
	
	public static void main(String[] args) {
		
		String a = "Hello";
		String b = "Java";
		String c = "Hello";
		
		System.out.println(a == c);
		System.out.println(a.equals(c));
		System.out.println(a == b);
		
		String d = new String("Hello");
		String e = new String("Java");
		String f = new String("Java");
		
		System.out.println("e == f      : " + (e == f));
		System.out.println("e.equals(f) : " + e.equals(f));
		
	}
	
}
