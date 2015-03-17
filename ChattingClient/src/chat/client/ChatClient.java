package chat.client;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.*;

public class ChatClient extends JFrame implements ActionListener {
	
	// 채팅 서버 주소
	private String serverAddress = "192.168.1.13";
	private int serverPort = 3000;
	
	// 접속 대화명
	private String nick;
	
	// 채팅 서버 접속용 소켓
	private Socket sock;
	
	// 입출력 스트림
	private BufferedReader in;
	private PrintWriter out;
	
	// 로그인 버튼
	private JButton loginButton;
	// 로그아웃 버튼
	private JButton logoutButton;
	
	// 로그인/로그아웃 패널 전환용 컴포넌트들
	private JPanel northPanel;
	private CardLayout cardLayout;
	
	private JTextField nickTextField;
	private JLabel logoutLabel;
	
	private JTextField messageInput;
	private JButton sendButton;
	
	public ChatClient() {
		setTitle("GUI 채팅 클라이언트");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		// 로그인 패널
		JPanel loginPanel = new JPanel();
		loginPanel.setLayout(new BorderLayout());
		// 레이블
		JLabel nickLabel = new JLabel("대화명:");
		loginPanel.add(nickLabel, BorderLayout.WEST);
		// 텍스트필드
		nickTextField = new JTextField();
		nickTextField.addActionListener(this);	// 엔터 이벤트 처리
		loginPanel.add(nickTextField, BorderLayout.CENTER);
		// 버튼
		loginButton = new JButton("로그인");
		loginButton.addActionListener(this);	// 자기 자신 객체를 ActionListener로 등록
		loginPanel.add(loginButton, BorderLayout.EAST);
		
		// 로그아웃 패널
		JPanel logoutPanel = new JPanel();
		logoutPanel.setLayout(new BorderLayout());
		// 레이블
		logoutLabel = new JLabel("대화명 'ooo'으로 로그인하였습니다.");
		logoutPanel.add(logoutLabel, BorderLayout.CENTER);
		// 로그아웃 버튼
		logoutButton = new JButton("로그아웃");
		logoutButton.addActionListener(this);	// 자기 자신 객체를 ActionListener로 등록
		logoutPanel.add(logoutButton, BorderLayout.EAST);
		
		// 카드 레이아웃 (로그인/로그아웃 패널 배치용)
		northPanel = new JPanel();
		cardLayout = new CardLayout();
		northPanel.setLayout(cardLayout);
		// 로그인 패널
		northPanel.add(loginPanel, "login");
		// 로그아웃 패널
		northPanel.add(logoutPanel, "logout");
		// northPanel을 화면 상단(NORTH) 구역에 배치
		contentPane.add(northPanel, BorderLayout.NORTH);
		// northPanel에 추가된 loginPanel/logoutPanel 중 loginPanel을 표시
		cardLayout.show(northPanel, "login");
		
		/*
		// TEST
		loginButton.addActionListener(new ActionListener() {	// 로그인 버튼을 클릭했을 때
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(northPanel, "logout");			// 로그아웃 패널이 표시되도록
			}
		});
		logoutButton.addActionListener(new ActionListener() {	// 로그아웃 버튼을 클릭했을 때
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(northPanel, "login");			// 로그인 패널이 표시되도록
			}
		});
		*/
		
		// 수신 메시지 출력부
		JTextArea messageView = new JTextArea();
		messageView.setEditable(false);
		JScrollPane messageViewScroll = new JScrollPane(messageView,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		contentPane.add(messageViewScroll, BorderLayout.CENTER);
		
		// 메시지 입력부
		JPanel messageInputPanel = new JPanel();
		messageInputPanel.setLayout(new BorderLayout());
		contentPane.add(messageInputPanel, BorderLayout.SOUTH);
		// 텍스트필드
		messageInput = new JTextField();
		messageInput.setEnabled(false);
		messageInput.addActionListener(this);	// 엔터 이벤트 처리
		messageInputPanel.add(messageInput, BorderLayout.CENTER);
		// 전송 버튼
		sendButton = new JButton("전송");
		sendButton.setEnabled(false);
		sendButton.addActionListener(this);	// 버튼 클릭 이벤트 처리
		messageInputPanel.add(sendButton, BorderLayout.EAST);
		
		setSize(480, 320);
		setVisible(true);
		
		nickTextField.requestFocus();	// GUI가 실행되면 바로 대화명 입력창으로 커서를 이동
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();	// 이벤트가 발생한 소스 컴포넌트
		// 로그인 버튼이 클릭?
		if (source == loginButton || source == nickTextField) {
			String nick = nickTextField.getText().trim();
			// 입력된 대화명의 유효성 검사
			if (nick.length() < 3) {
				// 대화명 유효하지 않음을 알림
				JOptionPane.showMessageDialog(this, "대화명은 3글자 이상으로 설정하세요.");
			} else {
				try {
					this.nick = nick;
					nickTextField.setText(this.nick);
					
					// 서버에 접속
					connect();
					// 서버에 대화명 전송
					sendMessage(this.nick);
					
					// 로그아웃 레이블에 텍스트 설정
					logoutLabel.setText("대화명 '" + this.nick + "'으로 로그인하였습니다.");
					// 로그아웃 패널이 표시되도록
					cardLayout.show(northPanel, "logout");
					
					// 메시지 입력부 활성화
					messageInput.setEnabled(true);
					sendButton.setEnabled(true);
					
					// 메시지 입력부로 포커스 이동
					messageInput.requestFocus();
					
				} catch (IOException ex) {
					JOptionPane.showMessageDialog(this, "서버 접속 실패 (" + ex.getMessage() + ")");
				}
			}
		}
		// 로그아웃 버튼이 클릭?
		else if (source == logoutButton) {
			disconnect();
			// 로그인 패널이 표시되도록
			cardLayout.show(northPanel, "login");
			// 메시지 입력부 비우고, 비활성화
			messageInput.setText("");
			messageInput.setEnabled(false);
			sendButton.setEnabled(false);
		}
		// messageInput 텍스트필드에서 엔터가 입력?
		else if (source == messageInput || source == sendButton) {
			// 메시지 전송
			String message = messageInput.getText().trim();
			if (message.length() > 0) {
				sendMessage(message);
			}
			// 텍스트필드 비우기
			messageInput.setText("");
		}
	}
	
	private void connect() throws UnknownHostException, IOException {
		// 서버에 접속
		sock = new Socket(serverAddress, serverPort);
		// 입출력 스트림 객체 생성
		out = new PrintWriter(sock.getOutputStream(), true);
		in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
	}
	
	private void disconnect() {
		if (sock != null) {
			try {
				sock.close();
			} catch (IOException e) {
			} finally {
				sock = null;
				out = null;
				in = null;
			}
		}
	}
	
	private void sendMessage(String message) {
		// 메시지 전송
		out.println(message);
	}
	
	public static void main(String[] args) {
		new ChatClient();
	}
	
}
