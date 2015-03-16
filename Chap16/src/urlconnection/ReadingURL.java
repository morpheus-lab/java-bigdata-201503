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
			
			BufferedReader in = new BufferedReader(	// ���۱���� �߰�
					new InputStreamReader(			// �����͸� ���� ������ ó��
							conn.getInputStream()));
			String aLine;
			while ((aLine = in.readLine()) != null) {	// �� �� ������ ó��
				System.out.println(aLine);
			}
			
			in.close();
			
		} catch (MalformedURLException e) {
			System.err.println("URL �߸���");
		} catch (IOException e) {
			System.err.println("I/O ����");
		}
		
		
	}
	
}
