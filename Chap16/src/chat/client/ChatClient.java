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
					String msgFromServer = reader.readLine();	// �����κ��� �޽��� ����
					System.out.println(msgFromServer);	// ���ŵ� �޽��� ȭ�� ���
				} catch (Exception e) {
					break;
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("����� ��ȭ���� �Է��ϼ���: ");
		String nick = sc.nextLine();
		
		Socket sock = null;
		BufferedReader in = null;
		BufferedWriter out = null;
		try {
			sock = new Socket("192.168.1.13", 3000);	// 192.168.1.13
			
			// ������ ���� �Ϸ�
			
			// sock�� �̿��ϸ� ������ ��� ����
			
			in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()));
			
			out.write(nick + "\n");	// ������ �޽����� �г���
			out.flush();
			
			MessageReaderThread t = new MessageReaderThread(in);
			t.start();
			
			while (true) {
				// �����͸� ������ ������
				String messageToSend = sc.nextLine();
				
				if (messageToSend.equals("/bye"))
					break;
				
				out.write(messageToSend + "\n");
				out.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NoSuchElementException e) {
			System.out.println("������ �����մϴ�.");
		} finally {
			if (sock != null)
				try {
					sock.close();
				} catch (IOException e) {}
		}
		System.out.println("\n���α׷��� �����մϴ�.\n");
	}
	
}
