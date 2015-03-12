package gui.event;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.*;

public class MouseListenerExam extends JFrame {
	
	JPanel contentPane = new JPanel();
	JLabel la;
	
	public MouseListenerExam() {
		setTitle("마우스 이벤트 리스너 테스트");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(contentPane);	// 콘텐트 팬 교체
		contentPane.addMouseListener(new MyMouseListener());	// 버튼 클릭, 프레스, 릴리즈, 커서 IN/OUT
		contentPane.addMouseMotionListener(new MyMouseListener());	// 드래그, 커서 이동
		
		la = new JLabel("No Mouse Event");
		contentPane.add(la);
		
		setSize(300, 300);
		setVisible(true);
	}
	
	class MyMouseListener implements MouseListener, MouseMotionListener {
		// MouseListener
		@Override
		public void mouseClicked(MouseEvent e) {
			if (e.getClickCount() == 2) {	// 더블 클릭 시
				int r = (int) (Math.random() * 256);
				int g = (int) (Math.random() * 256);
				int b = (int) (Math.random() * 256);
				Color c = new Color(r, g, b);
				contentPane.setBackground(c);
			}
		}
		@Override
		public void mousePressed(MouseEvent e) {
			la.setText("PRESS(" + e.getX() + ", " + e.getY() + ")");
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			la.setText("RELEASE(" + e.getX() + ", " + e.getY() + ")");
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			JPanel p = (JPanel) e.getSource();	// contentPane 객체
			p.setBackground(Color.CYAN);
		}
		@Override
		public void mouseExited(MouseEvent e) {
			JPanel p = (JPanel) e.getSource();	// contentPane 객체
			p.setBackground(Color.YELLOW);
		}
		// MouseMotionListener
		@Override
		public void mouseDragged(MouseEvent e) {
			la.setText("DRAGGED(" + e.getX() + ", " + e.getY() + ")");
		}
		@Override
		public void mouseMoved(MouseEvent e) {
			la.setText("MOVED(" + e.getX() + ", " + e.getY() + ")");
		}
	}
	
	public static void main(String[] args) {
		new MouseListenerExam();
	}
	
}
