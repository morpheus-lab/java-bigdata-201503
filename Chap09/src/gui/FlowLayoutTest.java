package gui;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class FlowLayoutTest {
	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		frame.setTitle("FlowLayout 테스트");
		frame.setSize(300, 300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = frame.getContentPane();
		c.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 40));
								// 왼쪽정렬, 수평30간격, 수직40간격
		c.add(new JButton("add"));
		c.add(new JButton("sub"));
		c.add(new JButton("mul"));
		c.add(new JButton("div"));
		c.add(new JButton("Calculate"));
		
	}
	
}
