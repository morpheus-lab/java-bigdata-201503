package url.spec;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class ParsingURL {
	
	public static void main(String[] args) {
		
		try {
			URL kbsNews = new URL("http://news.kbs.co.kr");
			
			String host = kbsNews.getHost();
			int port = kbsNews.getPort();
			String protocol = kbsNews.getProtocol();
			
			System.out.println("host    : " + host);
			System.out.println("port    : " + port);
			System.out.println("protocol: " + protocol);
			
			System.out.println("-----------------------------");
			
			URL kbsNewsMain = new URL(kbsNews, "common/NewsMain.html");
			// http://news.kbs.co.kr/common/NewsMain.html
			
			System.out.println("host: " + kbsNewsMain.getHost());
			System.out.println("protocol: " + kbsNewsMain.getProtocol());
			System.out.println("path: " + kbsNewsMain.getPath());
			System.out.println("file: " + kbsNewsMain.getFile());
			
			// kbsNewsMain으로부터 데이터 읽기
			InputStream in = kbsNewsMain.openStream();
			
			// 파일에 쓰기위한 객체
			FileOutputStream fOut = new FileOutputStream("D:\\kbs.html");
			
			byte[] buffer = new byte[1024];
			int length = 0;
			while ((length = in.read(buffer)) != -1) {
				fOut.write(buffer, 0, length);
			}
			
			System.out.println("파일 저장 완료");
			
			in.close();
			fOut.close();
			
		} catch (MalformedURLException e) {
			System.out.println("URL이 잘못되었습니다.");
		} catch (IOException e) {
			System.out.println("I/O 에러");
		}
		
	}
	
}
