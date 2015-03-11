package gui;

import java.awt.*;

import javax.swing.*;

public class MyGUIApp {
	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		frame.setTitle("ù ��° GUI ���α׷�");
		frame.setSize(300, 300);
		frame.setVisible(true);	// �����찡 ȭ�鿡 ��Ÿ��
		
		// �����츦 ���� �� ���α׷� ��ü�� �����Ϸ���
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/*
		// ContentPane �˾Ƴ���
		Container content = frame.getContentPane();
		
		// �ٿ����� ������Ʈ ����
		JButton button = new JButton("OK");
		
		// �����̳ʿ� ������Ʈ ���̱�
		content.add(button);
		*/
		
		// �����̳� ���� ����
		JPanel p = new JPanel();
		p.setBackground(Color.ORANGE);	// �����̳� ���� ����
		
		p.setLayout(new FlowLayout());	// ���̾ƿ� �Ŵ��� ����
//		p.setLayout(new BorderLayout());
		
		// �ٿ����� ������Ʈ ����
		JButton button = new JButton("OK");
		
		// �����̳ʿ� ������Ʈ �߰�
		p.add(button);
		
		p.add(new JButton("Cancel"));
		p.add(new JButton("Ignore"));
		
		// �� ���θ��� �����̳ʸ� Frame�� ContentPane���� ����
		frame.setContentPane(p);
	}
	
}
