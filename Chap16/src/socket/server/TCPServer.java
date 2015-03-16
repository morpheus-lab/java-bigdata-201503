package socket.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

class ServerThread extends Thread {
	
	private Socket sock;	// �� Ŭ���̾�Ʈ�� ����� ��Ʈ��ũ ����
	
	public ServerThread(Socket sock) {
		this.sock = sock;
	}
	
	@Override
	public void run() {
		BufferedReader in = null;
		BufferedWriter out = null;
		try {
			// ���ӵ� Ŭ���̾�Ʈ�� ���
			
			in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()));
			
			// in.read()	// Ŭ���̾�Ʈ�� ������ ������ ����
			// out.write()	// Ŭ���̾�Ʈ�� ������ ����
			
			String messageFromClient;
			
			while ((messageFromClient = in.readLine()) != null) {
				System.out.println("Ŭ���̾�Ʈ> " + messageFromClient);
				
				out.write(messageFromClient + "\n");
				out.flush();	// ���۰� �������� �ʾƵ� ����
			}
			
		} catch (IOException e) {
			e.printStackTrace();
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

public class TCPServer {
	
	public static void main(String[] args) {
		ServerSocket sSock = null;
		try {
			sSock = new ServerSocket(3000);
		} catch (IOException e) {
			System.err.println("�������� ���� ����");
			e.printStackTrace();
			System.exit(1);
		}
		
		while (true) {
			try {
				Socket sock = sSock.accept();	// Ŭ���̾�Ʈ�� ���ӵǱ⸦ ���, ���ӵǸ� Socket ��ü ��������
				ServerThread t = new ServerThread(sock);
				t.start();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}























