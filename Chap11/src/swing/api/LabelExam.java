package swing.api;

import java.awt.*;

import javax.swing.*;

public class LabelExam extends JFrame {
	
	public LabelExam() {
		setTitle("레이블 테스트");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		JLabel textLabel = new JLabel("안녕하세요");
		
		ImageIcon hearts = new ImageIcon("D:\\hearts.jpg");
		JLabel imageLabel = new JLabel(hearts);
		
		ImageIcon tel = new ImageIcon("D:\\tel.png");
		JLabel textImageLabel = new JLabel("콜미~", tel, SwingConstants.CENTER);
		
		contentPane.add(textLabel);
		contentPane.add(imageLabel);
		contentPane.add(textImageLabel);
		
		setSize(300, 600);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new LabelExam();
	}
	
}
