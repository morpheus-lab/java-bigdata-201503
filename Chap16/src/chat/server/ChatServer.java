package chat.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

class ChatThread extends Thread {
	
	private Socket sock;	// �� Ŭ���̾�Ʈ�� ����� ��Ʈ��ũ ����
	private BufferedWriter out;
	private String nick;
	
	public ChatThread(Socket sock) {
		this.sock = sock;
	}
	
	public void sendMessage(String message) throws IOException {
		out.write(message + "\n");
		out.flush();
	}
	
	public static void sendMsgToAll(String message) throws IOException {
		synchronized (ChatServer.clientList) {
			Iterator<ChatThread> iter = ChatServer.clientList.iterator();
			while (iter.hasNext()) {
				ChatThread t = iter.next();
				t.sendMessage(message);
			}
		}
	}
	
	@Override
	public void run() {
		BufferedReader in = null;
		
		try {
			// ���ӵ� Ŭ���̾�Ʈ�� ���
			
			in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()));
			
			// in.read()	// Ŭ���̾�Ʈ�� ������ ������ ����
			// out.write()	// Ŭ���̾�Ʈ�� ������ ����
			
			nick = in.readLine();	// Ŭ���̾�Ʈ�κ��� ���� �����ϴ� �޽����� nick�� ����
			
			// ���� �˸� => ��� Ŭ���̾�Ʈ����
			sendMsgToAll(">>> " + nick + " ���� �����Ͽ����ϴ�. <<<");
			
			String messageFromClient;
			
			while ((messageFromClient = in.readLine()) != null) {
				System.out.println(nick + "> " + messageFromClient);
				
//				out.write(messageFromClient + "\n");
//				out.flush();	// ���۰� �������� �ʾƵ� ����
				
				// ��� Ŭ���̾�Ʈ���� ����
//				synchronized (ChatServer.clientList) {
//					Iterator<ChatThread> iter = ChatServer.clientList.iterator();
//					while (iter.hasNext()) {
//						ChatThread t = iter.next();
//						t.sendMessage(nick + "> " + messageFromClient);
//					}
//				}
				sendMsgToAll(nick + ">" + messageFromClient);
			}
			
			sendMsgToAll(">>> " + nick + " ���� ���� �����Ͽ����ϴ�. <<<");
			
		} catch (IOException e) {
			System.err.println(e.getMessage());
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
			synchronized (ChatServer.clientList) {
				ChatServer.clientList.remove(this);
			}
		}
	}
}

public class ChatServer {
	
	static ArrayList<ChatThread> clientList = new ArrayList<ChatThread>();
	
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
				ChatThread t = new ChatThread(sock);
				t.start();
				synchronized (clientList) {
					clientList.add(t);	// Ŭ���̾�Ʈ ��Ͽ� ���ο� Ŭ���̾�Ʈ ChatThread ��ü �߰�
				}
				System.out.println("Ŭ���̾�Ʈ ���ӵ�: " + sock.getInetAddress());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}























