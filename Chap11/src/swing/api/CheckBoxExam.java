package swing.api;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;

public class CheckBoxExam extends JFrame {
	
	public CheckBoxExam() {
		setTitle("üũ �ڽ� �׽�Ʈ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		JCheckBox check1 = new JCheckBox("���");	// ���õ��� ���� ������ üũ�ڽ�
		JCheckBox check2 = new JCheckBox("��", true);	// ���õ� ������ üũ�ڽ�
		
		ImageIcon icon1 = new ImageIcon("D:\\tel.png");
		ImageIcon icon2 = new ImageIcon("D:\\tel1.png");
		
		JCheckBox check3 = new JCheckBox("��ȭ", icon1);	// �̹��� üũ�ڽ�
		check3.setBorderPainted(true);	// ��輱 �׸��� ����
		check3.setSelectedIcon(icon2);	// ���õ� ���� �̹��� ����
		
		contentPane.add(check1);
		contentPane.add(check2);
		contentPane.add(check3);
		
		setSize(300, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new CheckBoxExam();
	}
	
}
