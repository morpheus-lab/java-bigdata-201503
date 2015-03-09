package system.apis;

public class StringBufferTest {
	
	public static void main(String[] args) {
		
		StringBuffer sb1 = new StringBuffer();
		StringBuffer sb2 = new StringBuffer("abc");
		
		System.out.println(sb1);
		System.out.println("hash: " + sb1.hashCode());
		
		sb1.append("hello");
		sb1.append(true);
		sb1.append(10);
		sb1.append('Z');
		
		System.out.println(sb1);
		System.out.println("hash: " + sb1.hashCode());
		
		System.out.println("--------------------------");
		
		String s1 = new String();
		
		System.out.println(s1);
		System.out.println("String Hash: " + s1.hashCode());
		
		s1 += "hello";
		System.out.println("String Hash: " + s1.hashCode());
		s1 += true;
		System.out.println("String Hash: " + s1.hashCode());
		s1 += 10;
		System.out.println("String Hash: " + s1.hashCode());
		s1 += 'Z';
		
		System.out.println(s1);
		System.out.println("String Hash: " + s1.hashCode());
		
	}
	
}
