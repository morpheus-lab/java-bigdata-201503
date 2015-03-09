package system.apis;

public class StringMethods {
	
	public static void main(String[] args) {
		
		String s = "     Hello, Java°¡ Hello    ";
		
		System.out.println(s.charAt(1));
		System.out.println(s.codePointAt(1));
		System.out.println(s.compareTo("Hello, Jav"));
		System.out.println(s.concat(" !"));
		System.out.println(s.contains("illo"));
		System.out.println(s.length());
		System.out.println(s.replace('a', 'u'));
		System.out.println(s);
		System.out.println(s.replace("lo", "mi"));
		
		System.out.println("---------------------");
		
		String[] splited = s.split("a");
		for (String str : splited) {
			System.out.println(str);
		}
		
		System.out.println("---------------------");
		
		System.out.println(s.substring(3));
		System.out.println(s.substring(3, 10));	// [startIdx, endIdx)
		
		System.out.println("---------------------");
		
		System.out.println(s.toLowerCase());
		System.out.println(s.toUpperCase());
		System.out.println(s.trim());
		
	}
	
}
