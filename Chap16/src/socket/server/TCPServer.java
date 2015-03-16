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
	
	private Socket sock;	// 한 클라이언트와 연결된 네트워크 소켓
	
	public ServerThread(Socket sock) {
		this.sock = sock;
	}
	
	@Override
	public void run() {
		BufferedReader in = null;
		BufferedWriter out = null;
		try {
			// 접속된 클라이언트와 통신
			
			in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()));
			
			// in.read()	// 클라이언트가 보내는 데이터 읽음
			// out.write()	// 클라이언트에 데이터 보냄
			
			String messageFromClient;
			
			while ((messageFromClient = in.readLine()) != null) {
				System.out.println("클라이언트> " + messageFromClient);
				
				out.write(messageFromClient + "\n");
				out.flush();	// 버퍼가 가득차지 않아도 전송
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
			System.err.println("서버소켓 생성 실패");
			e.printStackTrace();
			System.exit(1);
		}
		
		while (true) {
			try {
				Socket sock = sSock.accept();	// 클라이언트가 접속되기를 대기, 접속되면 Socket 객체 생성해줌
				ServerThread t = new ServerThread(sock);
				t.start();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}























