package swing.api;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TextAreaExam extends JFrame {
	
	Container contentPane;
	
	public TextAreaExam() {
		setTitle("JTextArea �׽�Ʈ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = getContentPane();
		
		contentPane.add(new MyCenterPanel());
		
		setSize(300, 300);
		setVisible(true);
	}
	
	class MyCenterPanel extends JPanel {
		JTextField tf;
		JButton btn;
		JTextArea ta;
		
		public MyCenterPanel() {
			tf = new JTextField(20);	// ���� 20���� �� �� �ִ� ���� ���� �ؽ�Ʈ�ʵ�
			btn = new JButton("�߰�");
			btn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					ta.append(tf.getText() + "\n");
					tf.setText("");
				}
			});	// ��ư Ŭ�� �̺�Ʈ ó���� ������ �޾��� ��..
			ta = new JTextArea(7, 20);
			
			add(tf);
			add(btn);
			add(new JScrollPane(ta,
								JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
								JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));
		}
	}
	
	public static void main(String[] args) {
		new TextAreaExam();
	}
	
}
