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
		setTitle("Swing API 테스트");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		b1 = new JButton("위치와 크기 정보");
		b1.addActionListener(new MyButtonListener());
		contentPane.add(b1);
		
		b2 = new JButton("모양 정보");
		b2.setOpaque(true);
		b2.setForeground(Color.MAGENTA);
		b2.setBackground(Color.YELLOW);
		b2.setFont(new Font("맑은 고딕", Font.ITALIC, 20));
		b2.addActionListener(new MyButtonListener());
		contentPane.add(b2);
		
		b3 = new JButton("작동하지 않는 버튼");
		b3.setEnabled(false);
		b3.addActionListener(new MyButtonListener());
		contentPane.add(b3);
		
		b4 = new JButton("숨기기/보이기");
		b4.addActionListener(new MyButtonListener());
		contentPane.add(b4);
		
		la = new JLabel("");
		la.setSize(350, 30);
		contentPane.add(la);
		
		setSize(400, 250);	// 프레임 크기 설정
		setVisible(true);
	}
	
	class MyButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Object s = e.getSource();	// 이벤트 소스 (이벤트가 발생한 컴포넌트)
			
			if (s == b1) {
				String str = "버튼 위치 및 크기 ";
				str += "[위치: " + b1.getX() + "," + b1.getY() + "] ";
				str += "[크기: " + b1.getWidth() + "," + b1.getHeight() + "]";
				la.setText(str);
			}
			else if (s == b2) {
				String str = "모양 정보 ";
				// 폰트
				str += "[폰트: " + b2.getFont() + ", ";
				// 배경색
				str += "배경색: " + b2.getBackground() + ", ";
				// 전경색
				str += "전경색: " + b2.getForeground() + "]";
				
				la.setText(str);
			}
			else if (s == b3) {
				la.setText("b3 버튼 클릭되었음");
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
