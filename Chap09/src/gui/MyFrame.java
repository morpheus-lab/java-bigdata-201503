package gui;

import javax.swing.JFrame;

public class MyFrame extends JFrame {
	
	public MyFrame() {
		// ���� �Ӽ� ����
		setTitle("MyFrame");
		setSize(300, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		MyFrame window = new MyFrame();
	}
	
}
