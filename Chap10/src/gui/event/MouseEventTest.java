package gui.event;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class MouseEventTest extends JFrame {
	
	JLabel l;
	
	public MouseEventTest() {
		setTitle("���콺�� ȭ���� Ŭ���غ�����");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// �����̳�
		JPanel p = new JPanel();
		p.setLayout(null);	// ���̾ƿ� �Ŵ����� ���� => ������ǥ�� �̿��ؼ� ���� ������Ʈ�� ��ġ���Ѿ� ��
		
		// ���̺� ������Ʈ
		l = new JLabel("hello");
		l.setBounds(50, 10, 80, 20);
		p.add(l);
		
		// �����̳ʿ� ���콺 ������ �߰�
		/*
		p.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {
//				int x = e.getX();
//				int y = e.getY();
//				l.setLocation(x, y);
				l.setLocation(e.getPoint());
			}
			@Override
			public void mouseExited(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseClicked(MouseEvent e) {}
		});
		*/
		p.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				l.setLocation(e.getPoint());
			}
		});
		
		// JPanel p�� ����Ʈ ������ ����
		setContentPane(p);
		
		setSize(300, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MouseEventTest();
	}
	
	// ���� Ŭ����
	class MyMouseAdapter extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			l.setLocation(e.getPoint());
		}
	}
	
}




