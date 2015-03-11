package gui.event;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class KeyListenerEx extends JFrame {
	
	JPanel contentPane = new JPanel();
	JLabel[] keyMessage;
	
	public KeyListenerEx() {
		setTitle("KeyListener ����");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setContentPane(contentPane);
		contentPane.addKeyListener(new MyKeyListener());
		
		keyMessage = new JLabel[3];
		keyMessage[0] = new JLabel(" getKeyCode() ");
		keyMessage[1] = new JLabel(" getKeyChar() ");
		keyMessage[2] = new JLabel(" getKeyText() ");
		
		for (int i = 0; i < keyMessage.length; i++) {
			contentPane.add(keyMessage[i]);
			keyMessage[i].setOpaque(true);
			keyMessage[i].setBackground(Color.CYAN);
		}
		
		setSize(300, 150);
		setVisible(true);
		
		contentPane.requestFocus();	// contentPane�� Ű �̺�Ʈ�� ������ �� �ְ� ��
	}
	
	class MyKeyListener extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();
			char keyChar = e.getKeyChar();
			
			keyMessage[0].setText(keyCode + "");
			keyMessage[1].setText(keyChar + "");
			keyMessage[2].setText(KeyEvent.getKeyText(keyCode));
			
			// F1 Ű ��������
			if (keyCode == KeyEvent.VK_F1) {
				contentPane.setBackground(Color.GREEN);
			}
			// % Ű ��������
			else if (keyChar == '%') {
				contentPane.setBackground(Color.YELLOW);
			}
		}
	}
	
	public static void main(String[] args) {
		new KeyListenerEx();
	}
	
}

























