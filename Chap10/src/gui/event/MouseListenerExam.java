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
		setTitle("���콺 �̺�Ʈ ������ �׽�Ʈ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(contentPane);	// ����Ʈ �� ��ü
		contentPane.addMouseListener(new MyMouseListener());	// ��ư Ŭ��, ������, ������, Ŀ�� IN/OUT
		contentPane.addMouseMotionListener(new MyMouseListener());	// �巡��, Ŀ�� �̵�
		
		la = new JLabel("No Mouse Event");
		contentPane.add(la);
		
		setSize(300, 300);
		setVisible(true);
	}
	
	class MyMouseListener implements MouseListener, MouseMotionListener {
		// MouseListener
		@Override
		public void mouseClicked(MouseEvent e) {
			if (e.getClickCount() == 2) {	// ���� Ŭ�� ��
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
			JPanel p = (JPanel) e.getSource();	// contentPane ��ü
			p.setBackground(Color.CYAN);
		}
		@Override
		public void mouseExited(MouseEvent e) {
			JPanel p = (JPanel) e.getSource();	// contentPane ��ü
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
