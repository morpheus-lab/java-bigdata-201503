package socket.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class TCPClient {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Socket sock = null;
		BufferedReader in = null;
		BufferedWriter out = null;
		try {
			sock = new Socket("192.168.1.13", 3000);	// 192.168.1.13
			
			// 서버와 접속 완료
			
			// sock을 이용하면 서버와 통신 가능
			
			in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()));
			
			// in.read()	// 서버가 보내는 데이터 읽음
			// out.write()	// 서버에 데이터 보냄
			
			while (true) {
				// 데이터를 서버에 보내기
				System.out.print("보낼 메시지: ");
				String messageToSend = sc.nextLine();
				
				if (messageToSend.equals("bye"))
					break;
				
				out.write(messageToSend + "\n");
				out.flush();
				
				// 서버가 보내는 데이터 읽기
				String messageReceived = in.readLine();
				System.out.println("서버> " + messageReceived);
			}
			
			System.out.println("\n프로그램을 종료합니다.\n");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NoSuchElementException e) {
			System.out.println("접속을 종료합니다.");
		} finally {
			if (in != null)
				try {
					in.close();
				} catch (IOException e) {}
			if (out != null)
				try {
					out.close();
				} catch (IOException e) {}
			if (sock != null)
				try {
					sock.close();
				} catch (IOException e) {}
		}
	}
	
}
