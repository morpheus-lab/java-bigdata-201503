package gui.event;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class ArrowMove extends JFrame {
	
	JPanel content = new JPanel();
	JLabel hello = new JLabel("HELLO");
	
	public ArrowMove() {
		setTitle("��,��,��,�� Ű�� ���̺� �����̱�");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		content.setLayout(null);
		setContentPane(content);	// ����Ʈ �� ��ü
		
		content.add(hello);	// ����Ʈ �ҿ� ���̺� ������Ʈ �߰�
		hello.setBounds(50, 50, 40, 30);
		
		content.addKeyListener(new KeyAdapter() {	// KeyAdapter�� ��ӹ޴� �͸� Ŭ���� ��ü
			@Override
			public void keyPressed(KeyEvent e) {
				int originalX = hello.getLocation().x;
				int originalY = hello.getLocation().y;
				
				int panelWidth = content.getWidth();
				int panelHeight = content.getHeight();
				
				int maxX = panelWidth - hello.getWidth();
				int maxY = panelHeight - hello.getHeight();
				
				switch(e.getKeyCode()) {
				case KeyEvent.VK_UP:
					if (originalY == 0) return;
					hello.setLocation(originalX, originalY - 10);
					break;
				case KeyEvent.VK_DOWN:
					if (originalY > maxY - 10) return;
					hello.setLocation(originalX, originalY + 10);
					break;
				case KeyEvent.VK_LEFT:
					if (originalX == 0) return;
					hello.setLocation(originalX - 10, originalY);
					break;
				case KeyEvent.VK_RIGHT:
					if (originalX > maxX - 10) return;
					hello.setLocation(originalX + 10, originalY);
					break;
				}
			}
		});
		
		setSize(400, 400);
		setVisible(true);
		
		content.requestFocus();	// ��Ŀ���� ����Ʈ ������ �̵�
	}
	
	public static void main(String[] args) {
		new ArrowMove();
	}
	
}
