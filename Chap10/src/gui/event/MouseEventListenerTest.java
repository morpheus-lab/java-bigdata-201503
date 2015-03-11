package gui.event;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class MouseEventListenerTest extends JFrame {
	
	public MouseEventListenerTest() {
		setTitle("Mouse Event Listener �׽�Ʈ");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// Container
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		// Component �߰�
		JButton b = new JButton("���콺 Ŀ���� �÷�������");
		b.setBackground(Color.YELLOW);
		c.add(b);	// �����̳ʿ� ��ư �߰�
		
		// ���콺 �̺�Ʈ ������ ����
		MyMouseEventListener mmel = new MyMouseEventListener();
		
		// ��ư b�� ���콺 �̺�Ʈ ������ ����
		b.addMouseListener(mmel);
		
		setSize(300, 150);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MouseEventListenerTest();
	}
	
}

class MyMouseEventListener implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// ���콺 Ŀ���� ��ư�� �ö� �� ���� ����
		JButton b = (JButton) e.getSource();	// �̺�Ʈ�� �߻��� ������Ʈ ��ȸ
		b.setBackground(Color.RED);	// ������ RED��
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// ���콺 Ŀ���� ��ư���� ������ �� ���� ����
		JButton b = (JButton) e.getSource();	// �̺�Ʈ�� �߻��� ������Ʈ ��ȸ
		b.setBackground(Color.YELLOW);	// ������ YELLOW��
	}
	
}
























