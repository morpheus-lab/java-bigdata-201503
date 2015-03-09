package system.apis;

import java.util.*;

public class StringTokenizerTest {
	
	public static void main(String[] args) {
		
		String query = "name=gdhong&addr=hanyang&age=27";
		
		StringTokenizer st = null;
//		st = new StringTokenizer(query);	// 공백문자로 구분지음
		st = new StringTokenizer(query, "&");
//		st = new StringTokenizer(query, "&", true);
		
		while (st.hasMoreTokens()) {
			String token = st.nextToken();
			// token 처리
			System.out.println(token);
		}
		
		
	}
	
}
