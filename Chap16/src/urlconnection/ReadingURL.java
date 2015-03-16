package urlconnection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class ReadingURL {
	
	public static void main(String[] args) {
		
		try {
			URL url = new URL("http://www.daum.net");
			
			URLConnection conn = url.openConnection();
			
			System.out.println("Content-Type: " + conn.getContentType());
			System.out.println("Content-Encoding: " + conn.getContentEncoding());
			
			BufferedReader in = new BufferedReader(	// 버퍼기능을 추가
					new InputStreamReader(			// 데이터를 문자 단위로 처리
							conn.getInputStream()));
			String aLine;
			while ((aLine = in.readLine()) != null) {	// 한 줄 단위로 처리
				System.out.println(aLine);
			}
			
			in.close();
			
		} catch (MalformedURLException e) {
			System.err.println("URL 잘못됨");
		} catch (IOException e) {
			System.err.println("I/O 에러");
		}
		
		
	}
	
}
