package gui.event;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class MouseEventListenerTest extends JFrame {
	
	public MouseEventListenerTest() {
		setTitle("Mouse Event Listener 테스트");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// Container
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		// Component 추가
		JButton b = new JButton("마우스 커서를 올려보세요");
		b.setBackground(Color.YELLOW);
		c.add(b);	// 컨테이너에 버튼 추가
		
		// 마우스 이벤트 리스너 생성
		MyMouseEventListener mmel = new MyMouseEventListener();
		
		// 버튼 b에 마우스 이벤트 리스너 설정
		b.addMouseListener(mmel);
		
		setSize(300, 150);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MouseEventListenerTest();
	}
	
}

class MyMouseEventListener implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// 마우스 커서가 버튼에 올라갈 때 할일 정의
		JButton b = (JButton) e.getSource();	// 이벤트가 발생한 컴포넌트 조회
		b.setBackground(Color.RED);	// 배경색을 RED로
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// 마우스 커서가 버튼에서 내려올 때 할일 정의
		JButton b = (JButton) e.getSource();	// 이벤트가 발생한 컴포넌트 조회
		b.setBackground(Color.YELLOW);	// 배경색을 YELLOW로
	}
	
}
























