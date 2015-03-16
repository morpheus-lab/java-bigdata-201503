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
			
			// ������ ���� �Ϸ�
			
			// sock�� �̿��ϸ� ������ ��� ����
			
			in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()));
			
			// in.read()	// ������ ������ ������ ����
			// out.write()	// ������ ������ ����
			
			while (true) {
				// �����͸� ������ ������
				System.out.print("���� �޽���: ");
				String messageToSend = sc.nextLine();
				
				if (messageToSend.equals("bye"))
					break;
				
				out.write(messageToSend + "\n");
				out.flush();
				
				// ������ ������ ������ �б�
				String messageReceived = in.readLine();
				System.out.println("����> " + messageReceived);
			}
			
			System.out.println("\n���α׷��� �����մϴ�.\n");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NoSuchElementException e) {
			System.out.println("������ �����մϴ�.");
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
