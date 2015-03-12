package swing.graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawGraphicsExam extends JFrame {
	
	public DrawGraphicsExam() {
		setTitle("도형 그리기");
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
			// Color 설정
			g.setColor(Color.BLUE);
			// Font 설정
			g.setFont(new Font("Arial", Font.PLAIN, 30));
			
			// 문자 그리기
			g.drawString("Hey!", 50, 50);
			
			// Color 재설정
			g.setColor(new Color(0x00ff0000));
			
			// 선 그리기
			g.drawLine(50, 50, 250, 50);
			
			// Color 재설정
			g.setColor(Color.GREEN);
			
			// 사각형
			g.drawRect(100, 80, 200, 150);
			
			// Color 재설정
			g.setColor(Color.MAGENTA);
			
			// 타원
			g.drawOval(120, 100, 200, 150);
			
			// Color 재설정
			g.setColor(Color.CYAN);
			
			// 모서리 둥근 사각형
			g.drawRoundRect(80, 120, 200, 150, 20, 20);
			
			
		}
	}
	
	public static void main(String[] args) {
		new DrawGraphicsExam();
	}
	
}
