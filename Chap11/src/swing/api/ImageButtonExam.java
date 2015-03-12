package swing.api;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingConstants;

public class ImageButtonExam extends JFrame {
	
	public ImageButtonExam() {
		setTitle("��ư �̹��� �׽�Ʈ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = getContentPane();
//		contentPane.setLayout(new FlowLayout());
		
		// ImageIcon ��ü 3�� �غ� (����, ���콺����, Ŭ��)
		ImageIcon iconInit = new ImageIcon("D:\\tel.png");
		ImageIcon iconOver = new ImageIcon("D:\\tel1.png");
		ImageIcon iconClick = new ImageIcon("D:\\tel2.jpg");
		
		// JButton ��ü ����
		JButton button = new JButton("�ݹ�~!", iconInit);	// �ʱ� ���� �̹��� ����
		button.setRolloverIcon(iconOver);	// ���콺 Ŀ���� ��ư�� �ö� �ִ� ���� ��µ� �̹��� ����
		button.setPressedIcon(iconClick);	// ��ư�� ������ ���� ��µ� �̹��� ����
		
		// ���� ����
//		button.setHorizontalAlignment(SwingConstants.LEFT);
		button.setHorizontalAlignment(SwingConstants.CENTER);	// �⺻��
//		button.setHorizontalAlignment(SwingConstants.RIGHT);
		
		// ���� ����
//		button.setVerticalAlignment(SwingConstants.TOP);
		button.setVerticalAlignment(SwingConstants.CENTER);	// �⺻��
//		button.setVerticalAlignment(SwingConstants.BOTTOMs);
		
		contentPane.add(button);
		
		setSize(300, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new ImageButtonExam();
	}
	
}
