package webday2;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class URLEncodeTest {
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		
		String s1 = URLEncoder.encode("abc홍길동", "UTF-8");
		String s2 = URLEncoder.encode("abc홍길동", "EUC-KR");
		
		System.out.println("홍길동(UTF-8) : " + s1);
		System.out.println("홍길동(EUC-KR): " + s2);
		
		System.out.println("s1: " + URLDecoder.decode(s1, "UTF-8"));
		System.out.println("s1: " + URLDecoder.decode(s1, "EUC-KR"));
		
	}
	
}
