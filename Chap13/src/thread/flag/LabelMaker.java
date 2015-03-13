package thread.flag;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JLabel;

public class LabelMaker extends Thread {
	
	Container contentPane;
	
	boolean finishRequested = false;
	
	// �� ��ü�� ������ �Ǹ�
	// �ڵ����� ���̺��� �����,
	// ��� �����̳ʿ� ���̺��� ��ġ��Ű�� �۾���
	// ��� �ݺ� �����ϴ� �༮���� ������...
	public LabelMaker(Container c) {
		contentPane = c;
	}
	
	@Override
	public void run() {
		while (!finishRequested) {	// finishRequested�� true�� �Ǹ� while�� �ݺ� ��
			makeLabel(contentPane);
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				break;
			}
		}
		
		contentPane.removeAll();
		JLabel label = new JLabel("FINISH");
		label.setForeground(Color.RED);
		label.setFont(new Font("Arial", Font.BOLD, 20));
		label.setBounds(180, 160, 80, 30);
		contentPane.add(label);
		contentPane.repaint();
	}
	
	public void finish() {
		finishRequested = true;
	}
	
	// ���̺� ������Ʈ�� �����
	// �ܺο��� �˷��ִ� ���� ������Ʈ ��ġ��Ű��
	public void makeLabel(Container c) {
		int x = (int) (Math.random() * c.getWidth());
		int y = (int) (Math.random() * c.getHeight());
		
		JLabel label = new JLabel("Java");
		label.setSize(80, 30);
		label.setLocation(x, y);
		c.add(label);
		c.repaint();
	}
	
}
