package gui;

import javax.swing.JFrame;

public class MyFrame extends JFrame {
	
	public MyFrame() {
		// 각종 속성 지정
		setTitle("MyFrame");
		setSize(300, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		MyFrame window = new MyFrame();
	}
	
}
