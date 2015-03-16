package chat.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ChatClient {
	
	static class MessageReaderThread extends Thread {
		
		BufferedReader reader;
		
		public MessageReaderThread(BufferedReader reader) {
			this.reader = reader;
		}
		
		@Override
		public void run() {
			while (true) {
				try {
					String msgFromServer = reader.readLine();	// 서버로부터 메시지 수신
					System.out.println(msgFromServer);	// 수신된 메시지 화면 출력
				} catch (Exception e) {
					break;
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("사용할 대화명을 입력하세요: ");
		String nick = sc.nextLine();
		
		Socket sock = null;
		BufferedReader in = null;
		BufferedWriter out = null;
		try {
			sock = new Socket("192.168.1.13", 3000);	// 192.168.1.13
			
			// 서버와 접속 완료
			
			// sock을 이용하면 서버와 통신 가능
			
			in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()));
			
			out.write(nick + "\n");	// 최초의 메시지가 닉네임
			out.flush();
			
			MessageReaderThread t = new MessageReaderThread(in);
			t.start();
			
			while (true) {
				// 데이터를 서버에 보내기
				String messageToSend = sc.nextLine();
				
				if (messageToSend.equals("/bye"))
					break;
				
				out.write(messageToSend + "\n");
				out.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NoSuchElementException e) {
			System.out.println("접속을 종료합니다.");
		} finally {
			if (sock != null)
				try {
					sock.close();
				} catch (IOException e) {}
		}
		System.out.println("\n프로그램을 종료합니다.\n");
	}
	
}
