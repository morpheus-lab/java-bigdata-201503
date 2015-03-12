package swing.api;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SwingAPIExam extends JFrame {
	
	Container contentPane;
	JLabel la;
	JButton b1, b2, b3, b4;
	
	public SwingAPIExam() {
		setTitle("Swing API �׽�Ʈ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		b1 = new JButton("��ġ�� ũ�� ����");
		b1.addActionListener(new MyButtonListener());
		contentPane.add(b1);
		
		b2 = new JButton("��� ����");
		b2.setOpaque(true);
		b2.setForeground(Color.MAGENTA);
		b2.setBackground(Color.YELLOW);
		b2.setFont(new Font("���� ���", Font.ITALIC, 20));
		b2.addActionListener(new MyButtonListener());
		contentPane.add(b2);
		
		b3 = new JButton("�۵����� �ʴ� ��ư");
		b3.setEnabled(false);
		b3.addActionListener(new MyButtonListener());
		contentPane.add(b3);
		
		b4 = new JButton("�����/���̱�");
		b4.addActionListener(new MyButtonListener());
		contentPane.add(b4);
		
		la = new JLabel("");
		la.setSize(350, 30);
		contentPane.add(la);
		
		setSize(400, 250);	// ������ ũ�� ����
		setVisible(true);
	}
	
	class MyButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Object s = e.getSource();	// �̺�Ʈ �ҽ� (�̺�Ʈ�� �߻��� ������Ʈ)
			
			if (s == b1) {
				String str = "��ư ��ġ �� ũ�� ";
				str += "[��ġ: " + b1.getX() + "," + b1.getY() + "] ";
				str += "[ũ��: " + b1.getWidth() + "," + b1.getHeight() + "]";
				la.setText(str);
			}
			else if (s == b2) {
				String str = "��� ���� ";
				// ��Ʈ
				str += "[��Ʈ: " + b2.getFont() + ", ";
				// ����
				str += "����: " + b2.getBackground() + ", ";
				// �����
				str += "�����: " + b2.getForeground() + "]";
				
				la.setText(str);
			}
			else if (s == b3) {
				la.setText("b3 ��ư Ŭ���Ǿ���");
			}
			else if (s == b4) {
				if (b1.isVisible()) {
					b1.setVisible(false);
					b2.setVisible(false);
					b3.setVisible(false);
				}
				else {
					b1.setVisible(true);
					b2.setVisible(true);
					b3.setVisible(true);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		new SwingAPIExam();
	}
	
}
