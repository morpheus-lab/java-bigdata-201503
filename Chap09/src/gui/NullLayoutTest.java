package gui;

import java.awt.Container;

import javax.swing.*;

public class NullLayoutTest extends JFrame {
	
	public NullLayoutTest() {
		setTitle("��ġ������ ���� �����̳�");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// Container ��ü ��ȸ
		Container c = getContentPane();
		
		// �����̳� ��ġ�����ڸ� ����
		c.setLayout(null);
		
		// ������Ʈ �߰�
		JComponent comp = null;
		for (int i = 1; i < 10; i++) {
			comp = new JButton(i + "");	// �ڵ� ��ĳ����
			comp.setSize(100, 30);	// �ʺ� 100, ���� 30
			comp.setLocation(20 * i, 20 * i);
			c.add(comp);
		}
		
		comp = new JLabel("Hello, Press Buttons!");	// �ڵ� ��ĳ����
		comp.setSize(300, 20);
		comp.setLocation(250, 100);
		c.add(comp);
		
		// ������ ũ�� ���� �� ���̱�
		setSize(300, 250);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new NullLayoutTest();
	}
	
}

























