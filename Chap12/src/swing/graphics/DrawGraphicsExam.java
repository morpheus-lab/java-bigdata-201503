package swing.graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawGraphicsExam extends JFrame {
	
	public DrawGraphicsExam() {
		setTitle("���� �׸���");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MyPanel p = new MyPanel();
		getContentPane().add(p);
		
		setSize(480, 360);
		setVisible(true);
	}
	
	class MyPanel extends JPanel {
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			// Color ����
			g.setColor(Color.BLUE);
			// Font ����
			g.setFont(new Font("Arial", Font.PLAIN, 30));
			
			// ���� �׸���
			g.drawString("Hey!", 50, 50);
			
			// Color �缳��
			g.setColor(new Color(0x00ff0000));
			
			// �� �׸���
			g.drawLine(50, 50, 250, 50);
			
			// Color �缳��
			g.setColor(Color.GREEN);
			
			// �簢��
			g.drawRect(100, 80, 200, 150);
			
			// Color �缳��
			g.setColor(Color.MAGENTA);
			
			// Ÿ��
			g.drawOval(120, 100, 200, 150);
			
			// Color �缳��
			g.setColor(Color.CYAN);
			
			// �𼭸� �ձ� �簢��
			g.drawRoundRect(80, 120, 200, 150, 20, 20);
			
			
		}
	}
	
	public static void main(String[] args) {
		new DrawGraphicsExam();
	}
	
}
