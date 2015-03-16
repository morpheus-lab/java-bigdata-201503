package urlconnection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class SendingToURL {
	
	public static void main(String[] args) {
		
		try {
			URL url = new URL("http://httpbin.org/post");
			
			URLConnection conn = url.openConnection();
			conn.setDoOutput(true);	// ������ ���� ��� Ȱ��ȭ
			
			OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream());
			out.write("name=gdhong&id=gd");
			out.close();
			
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String aLine;
			while ((aLine = in.readLine()) != null)
				System.out.println(aLine);
			in.close();
			
		} catch (MalformedURLException e) {
			System.err.println("URL �߸���");
		} catch (IOException e) {
			System.err.println("I/O ����");
			e.printStackTrace();
		}
		
	}
	
}
