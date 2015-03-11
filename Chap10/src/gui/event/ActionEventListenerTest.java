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
		setTitle("Action Event Listener 테스트");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// 컨테이너
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		// 버튼 컴포넌트 생성
		JButton button = new JButton("Action");
		c.add(button);
		
		// 액션 이벤트 리스너 생성
		// ActionListener 인터페이스를 구현하는 익명 클래스의 객체 생성
		ActionListener al = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {	// e: 발생한 이벤트에 대한 정보를 가지고 있는 객체
				JButton button = (JButton) e.getSource();	// 이벤트가 발생한 이벤트 소스
				String buttonText = button.getText();
				if (buttonText.equals("Action"))
					button.setText("액션");
				else
					button.setText("Action");
			}
		};
		// 위에서 생성한 액션 이벤트 리스너 객체를 button에 달아주기
		button.addActionListener(al);
		
		
		setSize(400, 250);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new ActionEventListenerTest();
	}
	
}



















