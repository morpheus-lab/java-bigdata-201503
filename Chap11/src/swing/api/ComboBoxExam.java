package swing.api;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JComboBox;
import javax.swing.JFrame;

public class ComboBoxExam extends JFrame {
	
	Container contentPane;
	String[] fruits = {"���", "��", "����", "����", "���ξ���", "ü��", "����"};
	String[] names = {"ȫ�浿", "��û", "����", "�ȷ�", "Ȩ��"};
	
	public ComboBoxExam() {
		setTitle("�޺� �ڽ�");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		// �޺� �ڽ� 1 ����
		JComboBox<String> fCombo = new JComboBox<String>(fruits);
		contentPane.add(fCombo);
		
		// �޺� �ڽ� 2 ����
		JComboBox<String> nCombo = new JComboBox<String>();	// �ʱ� ������ ���� X
		for (int i = 0; i < names.length; i++) {
			nCombo.addItem(names[i]);	// �޺� �ڽ��� �������� ������ �߰�
		}
		contentPane.add(nCombo);
		
		setSize(300, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new ComboBoxExam();
	}
	
}
