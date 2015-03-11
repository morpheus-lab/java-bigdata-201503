package gui.event;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ActionEventListenerTest extends JFrame {
	
	public ActionEventListenerTest() {
		setTitle("Action Event Listener �׽�Ʈ");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// �����̳�
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		// ��ư ������Ʈ ����
		JButton button = new JButton("Action");
		c.add(button);
		
		// �׼� �̺�Ʈ ������ ����
		// ActionListener �������̽��� �����ϴ� �͸� Ŭ������ ��ü ����
		ActionListener al = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {	// e: �߻��� �̺�Ʈ�� ���� ������ ������ �ִ� ��ü
				JButton button = (JButton) e.getSource();	// �̺�Ʈ�� �߻��� �̺�Ʈ �ҽ�
				String buttonText = button.getText();
				if (buttonText.equals("Action"))
					button.setText("�׼�");
				else
					button.setText("Action");
			}
		};
		// ������ ������ �׼� �̺�Ʈ ������ ��ü�� button�� �޾��ֱ�
		button.addActionListener(al);
		
		
		setSize(400, 250);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new ActionEventListenerTest();
	}
	
}



















