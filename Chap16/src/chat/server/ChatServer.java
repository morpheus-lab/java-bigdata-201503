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
	
	private Socket sock;	// 한 클라이언트와 연결된 네트워크 소켓
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
			// 접속된 클라이언트와 통신
			
			in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()));
			
			// in.read()	// 클라이언트가 보내는 데이터 읽음
			// out.write()	// 클라이언트에 데이터 보냄
			
			nick = in.readLine();	// 클라이언트로부터 최초 수신하는 메시지를 nick에 저장
			
			// 접속 알림 => 모든 클라이언트에게
			sendMsgToAll(">>> " + nick + " 님이 접속하였습니다. <<<");
			
			String messageFromClient;
			
			while ((messageFromClient = in.readLine()) != null) {
				System.out.println(nick + "> " + messageFromClient);
				
//				out.write(messageFromClient + "\n");
//				out.flush();	// 버퍼가 가득차지 않아도 전송
				
				// 모든 클라이언트에게 전송
//				synchronized (ChatServer.clientList) {
//					Iterator<ChatThread> iter = ChatServer.clientList.iterator();
//					while (iter.hasNext()) {
//						ChatThread t = iter.next();
//						t.sendMessage(nick + "> " + messageFromClient);
//					}
//				}
				sendMsgToAll(nick + ">" + messageFromClient);
			}
			
			sendMsgToAll(">>> " + nick + " 님이 접속 종료하였습니다. <<<");
			
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
			System.err.println("서버소켓 생성 실패");
			e.printStackTrace();
			System.exit(1);
		}
		
		while (true) {
			try {
				Socket sock = sSock.accept();	// 클라이언트가 접속되기를 대기, 접속되면 Socket 객체 생성해줌
				ChatThread t = new ChatThread(sock);
				t.start();
				synchronized (clientList) {
					clientList.add(t);	// 클라이언트 목록에 새로운 클라이언트 ChatThread 객체 추가
				}
				System.out.println("클라이언트 접속됨: " + sock.getInetAddress());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}























