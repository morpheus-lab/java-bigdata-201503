package gui;

import java.awt.*;
import javax.swing.*;

public class BorderLayoutTest {
	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		frame.setTitle("BorderLayout �׽�Ʈ");
		frame.setSize(300, 300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = frame.getContentPane();
//		c.setLayout(new BorderLayout());
		c.setLayout(new BorderLayout(30, 20));	// ���򰣰� 30, �������� 20
		c.add(new JButton("add"), BorderLayout.NORTH);
		c.add(new JButton("sub"), BorderLayout.SOUTH);
		c.add(new JButton("mul"), BorderLayout.EAST);
		c.add(new JButton("div"), BorderLayout.WEST);
		c.add(new JButton("Calculate"), BorderLayout.CENTER);
		
	}
	
}
