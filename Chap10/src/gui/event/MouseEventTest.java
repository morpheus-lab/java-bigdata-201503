package gui.event;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class MouseEventTest extends JFrame {
	
	JLabel l;
	
	public MouseEventTest() {
		setTitle("마우스로 화면을 클릭해보세요");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// 컨테이너
		JPanel p = new JPanel();
		p.setLayout(null);	// 레이아웃 매니저를 제거 => 절대좌표를 이용해서 내용 컴포넌트를 배치시켜야 함
		
		// 레이블 컴포넌트
		l = new JLabel("hello");
		l.setBounds(50, 10, 80, 20);
		p.add(l);
		
		// 컨테이너에 마우스 리스너 추가
		/*
		p.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {
//				int x = e.getX();
//				int y = e.getY();
//				l.setLocation(x, y);
				l.setLocation(e.getPoint());
			}
			@Override
			public void mouseExited(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseClicked(MouseEvent e) {}
		});
		*/
		p.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				l.setLocation(e.getPoint());
			}
		});
		
		// JPanel p를 컨텐트 팬으로 설정
		setContentPane(p);
		
		setSize(300, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MouseEventTest();
	}
	
	// 내부 클래스
	class MyMouseAdapter extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			l.setLocation(e.getPoint());
		}
	}
	
}




