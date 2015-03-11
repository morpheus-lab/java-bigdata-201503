package gui;

import java.awt.Container;

import javax.swing.*;

public class NullLayoutTest extends JFrame {
	
	public NullLayoutTest() {
		setTitle("배치관리자 없는 컨테이너");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// Container 객체 조회
		Container c = getContentPane();
		
		// 컨테이너 배치관리자를 제거
		c.setLayout(null);
		
		// 컴포넌트 추가
		JComponent comp = null;
		for (int i = 1; i < 10; i++) {
			comp = new JButton(i + "");	// 자동 업캐스팅
			comp.setSize(100, 30);	// 너비 100, 높이 30
			comp.setLocation(20 * i, 20 * i);
			c.add(comp);
		}
		
		comp = new JLabel("Hello, Press Buttons!");	// 자동 업캐스팅
		comp.setSize(300, 20);
		comp.setLocation(250, 100);
		c.add(comp);
		
		// 윈도우 크기 설정 및 보이기
		setSize(300, 250);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new NullLayoutTest();
	}
	
}

























