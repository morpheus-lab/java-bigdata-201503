package thread.flag;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

public class Window extends JFrame {
	
	public Window() {
		// UI�� �⺻ �Ӽ� ����
		
		// Ÿ��Ʋ �� �ؽ�Ʈ ����
		setTitle("Ÿ��Ʋ~~~~~");
		
		// �����ư Ŭ�� �� ���α׷� ����ǵ��� ó��
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// ������Ʈ�� �������� ��ġ��Ű�� ����
		getContentPane().setLayout(null);
		
		// LabelMaker ��ü���� ���̺��� �߰��ش޶�
		LabelMaker maker = new LabelMaker(getContentPane());
//		maker.makeLabel(getContentPane());	// �� Window ��ü�� ���� �ִ� contentPane ��ü�� maker ��ü���� ����
		maker.start();
		
		getContentPane().addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				maker.finish();
			}
		});
		
		// ������ ũ�� ����
		setSize(400, 300);
		
		// �����츦 ȭ�鿡 ���̱�
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Window();
	}
	
}
