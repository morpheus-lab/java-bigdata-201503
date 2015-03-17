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
	
	// ä�� ���� �ּ�
	private String serverAddress = "192.168.1.13";
	private int serverPort = 3000;
	
	// ���� ��ȭ��
	private String nick;
	
	// ä�� ���� ���ӿ� ����
	private Socket sock;
	
	// ����� ��Ʈ��
	private BufferedReader in;
	private PrintWriter out;
	
	// �α��� ��ư
	private JButton loginButton;
	// �α׾ƿ� ��ư
	private JButton logoutButton;
	
	// �α���/�α׾ƿ� �г� ��ȯ�� ������Ʈ��
	private JPanel northPanel;
	private CardLayout cardLayout;
	
	private JTextField nickTextField;
	private JLabel logoutLabel;
	
	private JTextField messageInput;
	private JButton sendButton;
	
	public ChatClient() {
		setTitle("GUI ä�� Ŭ���̾�Ʈ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		// �α��� �г�
		JPanel loginPanel = new JPanel();
		loginPanel.setLayout(new BorderLayout());
		// ���̺�
		JLabel nickLabel = new JLabel("��ȭ��:");
		loginPanel.add(nickLabel, BorderLayout.WEST);
		// �ؽ�Ʈ�ʵ�
		nickTextField = new JTextField();
		nickTextField.addActionListener(this);	// ���� �̺�Ʈ ó��
		loginPanel.add(nickTextField, BorderLayout.CENTER);
		// ��ư
		loginButton = new JButton("�α���");
		loginButton.addActionListener(this);	// �ڱ� �ڽ� ��ü�� ActionListener�� ���
		loginPanel.add(loginButton, BorderLayout.EAST);
		
		// �α׾ƿ� �г�
		JPanel logoutPanel = new JPanel();
		logoutPanel.setLayout(new BorderLayout());
		// ���̺�
		logoutLabel = new JLabel("��ȭ�� 'ooo'���� �α����Ͽ����ϴ�.");
		logoutPanel.add(logoutLabel, BorderLayout.CENTER);
		// �α׾ƿ� ��ư
		logoutButton = new JButton("�α׾ƿ�");
		logoutButton.addActionListener(this);	// �ڱ� �ڽ� ��ü�� ActionListener�� ���
		logoutPanel.add(logoutButton, BorderLayout.EAST);
		
		// ī�� ���̾ƿ� (�α���/�α׾ƿ� �г� ��ġ��)
		northPanel = new JPanel();
		cardLayout = new CardLayout();
		northPanel.setLayout(cardLayout);
		// �α��� �г�
		northPanel.add(loginPanel, "login");
		// �α׾ƿ� �г�
		northPanel.add(logoutPanel, "logout");
		// northPanel�� ȭ�� ���(NORTH) ������ ��ġ
		contentPane.add(northPanel, BorderLayout.NORTH);
		// northPanel�� �߰��� loginPanel/logoutPanel �� loginPanel�� ǥ��
		cardLayout.show(northPanel, "login");
		
		/*
		// TEST
		loginButton.addActionListener(new ActionListener() {	// �α��� ��ư�� Ŭ������ ��
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(northPanel, "logout");			// �α׾ƿ� �г��� ǥ�õǵ���
			}
		});
		logoutButton.addActionListener(new ActionListener() {	// �α׾ƿ� ��ư�� Ŭ������ ��
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(northPanel, "login");			// �α��� �г��� ǥ�õǵ���
			}
		});
		*/
		
		// ���� �޽��� ��º�
		JTextArea messageView = new JTextArea();
		messageView.setEditable(false);
		JScrollPane messageViewScroll = new JScrollPane(messageView,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		contentPane.add(messageViewScroll, BorderLayout.CENTER);
		
		// �޽��� �Էº�
		JPanel messageInputPanel = new JPanel();
		messageInputPanel.setLayout(new BorderLayout());
		contentPane.add(messageInputPanel, BorderLayout.SOUTH);
		// �ؽ�Ʈ�ʵ�
		messageInput = new JTextField();
		messageInput.setEnabled(false);
		messageInput.addActionListener(this);	// ���� �̺�Ʈ ó��
		messageInputPanel.add(messageInput, BorderLayout.CENTER);
		// ���� ��ư
		sendButton = new JButton("����");
		sendButton.setEnabled(false);
		sendButton.addActionListener(this);	// ��ư Ŭ�� �̺�Ʈ ó��
		messageInputPanel.add(sendButton, BorderLayout.EAST);
		
		setSize(480, 320);
		setVisible(true);
		
		nickTextField.requestFocus();	// GUI�� ����Ǹ� �ٷ� ��ȭ�� �Է�â���� Ŀ���� �̵�
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();	// �̺�Ʈ�� �߻��� �ҽ� ������Ʈ
		// �α��� ��ư�� Ŭ��?
		if (source == loginButton || source == nickTextField) {
			String nick = nickTextField.getText().trim();
			// �Էµ� ��ȭ���� ��ȿ�� �˻�
			if (nick.length() < 3) {
				// ��ȭ�� ��ȿ���� ������ �˸�
				JOptionPane.showMessageDialog(this, "��ȭ���� 3���� �̻����� �����ϼ���.");
			} else {
				try {
					this.nick = nick;
					nickTextField.setText(this.nick);
					
					// ������ ����
					connect();
					// ������ ��ȭ�� ����
					sendMessage(this.nick);
					
					// �α׾ƿ� ���̺� �ؽ�Ʈ ����
					logoutLabel.setText("��ȭ�� '" + this.nick + "'���� �α����Ͽ����ϴ�.");
					// �α׾ƿ� �г��� ǥ�õǵ���
					cardLayout.show(northPanel, "logout");
					
					// �޽��� �Էº� Ȱ��ȭ
					messageInput.setEnabled(true);
					sendButton.setEnabled(true);
					
					// �޽��� �Էºη� ��Ŀ�� �̵�
					messageInput.requestFocus();
					
				} catch (IOException ex) {
					JOptionPane.showMessageDialog(this, "���� ���� ���� (" + ex.getMessage() + ")");
				}
			}
		}
		// �α׾ƿ� ��ư�� Ŭ��?
		else if (source == logoutButton) {
			disconnect();
			// �α��� �г��� ǥ�õǵ���
			cardLayout.show(northPanel, "login");
			// �޽��� �Էº� ����, ��Ȱ��ȭ
			messageInput.setText("");
			messageInput.setEnabled(false);
			sendButton.setEnabled(false);
		}
		// messageInput �ؽ�Ʈ�ʵ忡�� ���Ͱ� �Է�?
		else if (source == messageInput || source == sendButton) {
			// �޽��� ����
			String message = messageInput.getText().trim();
			if (message.length() > 0) {
				sendMessage(message);
			}
			// �ؽ�Ʈ�ʵ� ����
			messageInput.setText("");
		}
	}
	
	private void connect() throws UnknownHostException, IOException {
		// ������ ����
		sock = new Socket(serverAddress, serverPort);
		// ����� ��Ʈ�� ��ü ����
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
		// �޽��� ����
		out.println(message);
	}
	
	public static void main(String[] args) {
		new ChatClient();
	}
	
}
