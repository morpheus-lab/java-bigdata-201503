package gui;

import java.awt.*;

import javax.swing.*;

public class GridLayoutTest extends JFrame {
	
	public GridLayoutTest() {
		this("GridLayout ����");
	}
	
	public GridLayoutTest(String windowTitle) {
		setTitle(windowTitle);
		
		// �����̳� ��ü ��ȸ
		Container c = getContentPane();
		
		// ���̾ƿ� �Ŵ��� ����
		GridLayout layout = new GridLayout(4, 2);
		layout.setVgap(5);
		c.setLayout(layout);
		
		// ������Ʈ �߰�
		c.add(new JLabel("�̸�"));
		c.add(new JTextField("ȫ�浿"));
		c.add(new JLabel("�й�"));
		c.add(new JTextField("101"));
		c.add(new JLabel("�а�"));
		c.add(new JTextField("�İ�"));
		c.add(new JLabel("����"));
		c.add(new JTextField("�ڹ�"));
		
		setSize(400, 250);
		setVisible(true);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new GridLayoutTest();
	}
	
}
